package xiancheng.test1;

public class MyThread2 implements Runnable {

    private String name;

    public MyThread2(String name){
        this.name = name;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        name = "new";
        System.out.println(this.name);
    }


    public static void main(String[] args) {
        MyThread2 myThread2 = new MyThread2("sss");
        Thread thread2 = new Thread(myThread2);
        thread2.start();
        //同步线程结果
        try {
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("name is" + myThread2.name);
    }
}
