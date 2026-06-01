package Mesho;

public class BlockInventory {

    String productId;
    int count;
    long blockTime;


    public BlockInventory(String productId, int count) {
        this.productId = productId;
        this.count = count;
        this.blockTime = System.currentTimeMillis();
    }
}
