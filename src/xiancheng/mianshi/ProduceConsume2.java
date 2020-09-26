package xiancheng.mianshi;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProduceConsume2 {

    static class Produce extends Thread {

        private ArrayBlockingQueue<Integer> queue;

        public Produce(ArrayBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 100; i++) {
                    queue.put(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    static class Consumer extends Thread {

        private ArrayBlockingQueue<Integer> queue;

        public Consumer(ArrayBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Integer take = queue.take();
                    System.out.println(take);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);
        Produce produce = new Produce(queue);
        Consumer consumer = new Consumer(queue);
        produce.start();
        consumer.start();
    }

}
