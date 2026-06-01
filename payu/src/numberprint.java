public class numberprint implements Runnable {

    private static final int max = 100;
    private static int number = 1;

    private final Object lock;

    public numberprint(Object lock) {
        this.lock = lock;
    }


    @Override
    public void run() {

        while (number <= max) {
            synchronized (lock) {
                System.out.println(Thread.currentThread().getName() + ": " + number);
                number++;
                lock.notify();

                try {
                    if (number <= max) {
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        }

    }
}
