package common.test;


class Task implements Runnable {

    private static int count = 0;

    private static Object lock = new Object();

    @Override
    public void run() {
        while (count < 100) {
            synchronized (lock) {
                System.out.println(count++);
                lock.notifyAll();
                try {
                    if (count < 100) {
                        lock.wait();
                    }
                }catch (Exception e) {

                }
            }
        }
    }
}

public class TwoTask {


    public static void main(String[] args) {
        new Thread(new Task(), "a").start();
        new Thread(new Task(), "b").start();
    }
}
