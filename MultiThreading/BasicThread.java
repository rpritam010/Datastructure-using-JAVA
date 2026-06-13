package MultiThreading;

public class BasicThread {
    public static void main(String[] args) {
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        thread1.start();
        thread2.start();

    }

    static class MyThread extends Thread {
        public void run() {
            System.out.println("Thread is running: " + Thread.currentThread().getName());
        }
    }
}
