package Mesho;

public class InventoryServiceProductBlocking {
    public static void main(String[] args) throws InterruptedException {
        InventoryManager inventory = new InventoryService();

        //Create product
        inventory.createProduct("P1","Macbook",10);

        System.out.println("Initial Stock of P1:" + inventory.getInventory("P1"));
        inventory.blockInventory("P1",3,"O1");
        System.out.println("Initial Stock of P1:" + inventory.getInventory("P1"));//7
        Thread.sleep(3000);
        inventory.blockInventory("P1",4,"O2");
        System.out.println("Initial Stock of P1:" + inventory.getInventory("P1"));//3

        inventory.blockInventory("P1",2,"O3");
        System.out.println("Initial Stock of P1:" + inventory.getInventory("P1"));//1
        Thread.sleep(3000);
        inventory.confirmOrder("O2");
        System.out.println("Initial Stock of P1:" + inventory.getInventory("P1"));//4
        Thread.sleep(3000);
        System.out.println("Initial Stock of P1:" + inventory.getInventory("P1"));



//        Runnable user1 = () -> {
//            inventory.blockInventory("P1",3,"O1");
//            try {
//                Thread.sleep(2000);
//                inventory.confirmOrder("O1");
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        };
//
//        Runnable user2 = () -> {
//            inventory.blockInventory("P1",4,"O2");
////            try {
////                Thread.sleep(6000);
////                inventory.confirmOrder("O3");
////            }catch (InterruptedException e){
////                e.printStackTrace();
////            }
//        };
//        Runnable user3 = () -> {
//            inventory.blockInventory("P1",2,"O3");
//            try {
//                Thread.sleep(1000);
//                inventory.confirmOrder("O3");
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        };
//
//        Thread t1 = new Thread(user1);
//        Thread t2 = new Thread(user2);
//        Thread t3 = new Thread(user3);
//        t1.start();
//        t2.start();
//        t3.start();
//
//        t1.join();
//        t2.join();
//        t3.join();


    }
}
