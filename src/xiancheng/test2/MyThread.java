package xiancheng.test2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyThread {

    public static void main(String[] args) {
        FutureTask<String> task = new FutureTask<String>(new MyCallable());
        Thread thread = new Thread(task);
        thread.start();
        if (!task.isDone()){
            System.out.println("task is not down");
        }
        try {
            System.out.println("end "+task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
