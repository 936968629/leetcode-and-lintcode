package xiancheng.mianshi;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resource{

    private Integer data = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void produce() {
        lock.lock();
        try {
            //判断
            while ( data != 0){
                //等待
                condition.await();
            }
            data++;
            System.out.println(Thread.currentThread().getId()+" 生产者："+data);
            //通知唤醒
            condition.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consumer(){
        lock.lock();
        try {
            while (data == 0){
                condition.await();
            }
            data--;
            System.out.println(Thread.currentThread().getId()+" 消费者："+data);
            condition.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}


public class ProducesConsume {

    public static void main(String[] args) {
        Resource resource = new Resource();
        new Thread(() ->{
            for (int i = 0; i < 5; i++) {
                resource.produce();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                resource.consumer();
            }
        }).start();

    }

}
