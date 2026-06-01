package Mesho;

public interface InventoryManager {

    void createProduct(String productId,String name,Integer count);
    Integer getInventory(String productId);

    void blockInventory(String productId,Integer count,String orderId);
    void confirmOrder(String orderId);
}
