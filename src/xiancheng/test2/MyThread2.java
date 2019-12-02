package xiancheng.test2;

import java.util.concurrent.*;

public class MyThread2 {

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newCachedThreadPool();
        Future<String> future = threadPool.submit(new MyCallable());
        if (!future.isDone()){
            System.out.println("task is not down");
        }

        try {
            System.out.println("get is "+future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}
