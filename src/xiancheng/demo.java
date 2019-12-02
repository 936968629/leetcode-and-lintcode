package xiancheng;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class demo {

    static AtomicInteger atomicInteger = new AtomicInteger();

    static AtomicStampedReference atomicStampedReference = new AtomicStampedReference(1,1);


    public static void main(String[] args) {
        boolean b = atomicInteger.compareAndSet(1, 1);

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }).start();



        List<Integer> list = Collections.synchronizedList(new ArrayList());


        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(3);
                System.out.println(list);
            },String.valueOf(i)).start();
        }
        //java.util.ConcurrentModificationException

//        System.out.println(list.toString());

    }
}
