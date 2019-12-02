package xiancheng.test2;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    @Override
    public String call() throws Exception {
        String value = "tets";
        System.out.println("task is start");
        Thread.sleep(3000);

        System.out.println("task down");
        value = "new";
        return value;
    }
}
