package xiancheng;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class MaxThreadPoolExecutor extends ThreadPoolExecutor {

    private AtomicLong submmitTaskCount = new AtomicLong(0);

    public MaxThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, MaxTaskQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public long getSubmmitTaskCount() {
        return this.submmitTaskCount.get();
    }

    @Override
    public void execute(Runnable command) {
        submmitTaskCount.incrementAndGet();
        try {
            super.execute(command);
        }catch (RejectedExecutionException e) {
            submmitTaskCount.decrementAndGet();
            throw e;
        }

    }

    public static void main(String[] args) {
        MaxTaskQueue<Runnable> queues = new MaxTaskQueue<>(10);
        MaxThreadPoolExecutor myThreadPoolExecutor = new MaxThreadPoolExecutor(2, 4, 3, TimeUnit.SECONDS, queues);
        queues.setMyThreadPoolExecutor(myThreadPoolExecutor);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 3, TimeUnit.SECONDS, new LinkedBlockingDeque<>(10));
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            myThreadPoolExecutor.execute(() -> {
                try {
                    System.out.println(finalI);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

//        threadPoolExecutor.shutdown();
    }


}
