package xiancheng.test3;

import java.util.concurrent.Callable;

public class WaitDemo {

    public static void main(String[] args) {
        final Object lock = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread A is start");
                synchronized (lock){
                    System.out.println("thread a get lock");
                    try {
                        Thread.sleep(20);
                        System.out.println("thread a is sleep");
//                        lock.wait(1000);
                        Thread.sleep(1000);
                        System.out.println("thread A is end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread B is start");
                synchronized (lock){
                    System.out.println("thread B get lock");
                    try {
                        Thread.sleep(10);
                        System.out.println("thread b is sleep");
                        Thread.sleep(1000);
//                        lock.wait(1000);
                        System.out.println("thread b is end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        }).start();

    }
}
