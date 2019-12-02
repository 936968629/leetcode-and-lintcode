package xiancheng.kechongru;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo {


    public synchronized void fun1(){
        System.out.println(Thread.currentThread().getId()+" fun1");
        fun2();
    }

    public synchronized void fun2(){
        System.out.println(Thread.currentThread().getId() + " fun2");
    }

    public Lock lock = new ReentrantLock();

    public void fun3(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId() + " fun3");
            fun4();
        }finally {
            lock.unlock();
        }

    }

    public void fun4(){
        lock.lock();
//        lock.lock();
        try {
            System.out.println(Thread.currentThread().getId() + " fun4");
        }finally {
//            lock.unlock();
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Demo demo = new Demo();

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
//                demo.fun1();
                demo.fun3();
            }).start();
        }

        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
