public class Main {
    public static void main(String[] args) {

        //System.out.println("Hello world!");

        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int area = maxArea(height);
        //System.out.println(area);

        ///Multithreading
        Object lock = new Object();
numberprint task = new numberprint(lock);

        Thread t1 = new Thread(task,"Thread1");
        Thread t2 = new Thread(task,"thread2");

        t1.start();
        t2.start();
    }

    public static int maxArea(int[] height) {
        int left = 0;

        int reight = height.length - 1;

        int totalWater = 0;

        while (left < reight) {

            int area = Math.min(height[left], height[reight]) * (reight - left);
            totalWater = Math.max(totalWater, area);

            if (height[left] < height[reight]) {
                left++;
            } else {
                reight--;
            }

        }
        return totalWater;

    }

}
