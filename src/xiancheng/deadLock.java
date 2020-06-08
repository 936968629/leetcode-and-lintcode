package xiancheng;

class Resource implements Runnable{

    private String lockA;

    private String lockB;

    public Resource(String lockA, String lockB){
        this.lockA = lockA;
        this.lockB = lockB;
    }


    @Override
    public void run(){
        synchronized (lockA){
            try {
                Thread.sleep(1000);
                synchronized (lockB){
                    System.out.println("获取B");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



public class deadLock {

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new Resource(lockA, lockB)).start();
        new Thread(new Resource(lockB, lockA)).start();
    }
}
