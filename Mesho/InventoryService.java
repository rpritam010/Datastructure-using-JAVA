package Mesho;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class InventoryService implements InventoryManager{

    private final ConcurrentHashMap<String,Product> productMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String,Integer> productStock = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String,BlockInventory> blockOrders = new ConcurrentHashMap<>();
    private final Set<String> confirmOrders = ConcurrentHashMap.newKeySet();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    private final ReentrantLock lock = new ReentrantLock();


    @Override
    public void createProduct(String productId, String name, Integer count) {
        synchronized (lock){
            productMap.put(productId,new Product(productId,name));
            productStock.put(productId,count);
        }

    }

    @Override
    public Integer getInventory(String productId) {
        return productStock.getOrDefault(productId,0);
    }

    @Override
    public void blockInventory(String productId, Integer count, String orderId) {
        lock.lock();
        try{
            int available = productStock.getOrDefault(productId,0);
            if(available<count){
                System.out.println("Insufficient stock to block");
                return;
            }
            //Block inventory
            productStock.put(productId,available-count);
            blockOrders.put(orderId,new BlockInventory(productId,count));

            scheduler.schedule(()-> releaseIfNotConfirmed(orderId,count,productId),5, TimeUnit.SECONDS );
            System.out.println("Blocked" + count +"units of " + productId +"for order"+orderId);
        } finally {
            lock.unlock();
        }

    }

    private void releaseIfNotConfirmed(String orderId,int count,String productId){
        lock.lock();
        try {
            if(confirmOrders.contains(orderId)){
                return;
            }
            BlockInventory blocked = blockOrders.remove(orderId);
            if(blocked != null){
                productStock.put(blocked.productId,productStock.getOrDefault(blocked.productId,0));
                productStock.put(productId,count +getInventory(productId));
                System.out.println("The order released :"+orderId);
            }
        }finally {
            lock.unlock();
        }
    }

    @Override
    public void confirmOrder(String orderId) {
        lock.lock();
        try {
            BlockInventory blocked = blockOrders.remove(orderId);
            if(blocked == null){
                System.out.println("No such blocked order or already expired : "+orderId);
                return;
            }
            confirmOrders.add(orderId);
            System.out.println("Order confirmed and inventory is reduced :" +orderId);
        }finally {
            lock.unlock();
        }

    }
}
