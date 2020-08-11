package xiancheng;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicLong;

public class MaxTaskQueue<R extends Runnable> extends LinkedBlockingQueue<Runnable> {

    private MaxThreadPoolExecutor executor;

    public MaxTaskQueue(int capacity) {
        super(capacity);
    }

    public void setMyThreadPoolExecutor(MaxThreadPoolExecutor myThreadPoolExecutor) {
        this.executor = myThreadPoolExecutor;
    }


    /**
     * 按照core - max - queue执行顺序
     * @param runnable
     * @return
     */
    @Override
    public boolean offer(Runnable runnable) {
        if (executor == null) {
            throw new RejectedExecutionException("executor is null");
        }
        int currentPoolThreadSize = executor.getPoolSize();
        AtomicLong submmitTaskCount = executor.getSubmmitTaskCount();
        

        if (currentPoolThreadSize < executor.getMaximumPoolSize() ) {
            return false;
        }

        return super.offer(runnable);
    }
}
