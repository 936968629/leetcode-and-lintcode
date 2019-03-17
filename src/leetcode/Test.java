package com.leetcode;

class MyTeard extends Thread{
    public void run(){

        for(int i = 0; i< 10000; i++) {
            Test.temp += 1;
        }

    }


}

class MyTeard2 extends Thread{
    public void run(){
        for(int i = 0; i< 10000; i++) {
            Test.temp -= 1;
        }

    }
}

public class Test {

    public static int temp = 6;

    public static void main(String arg[]) {

        Thread t1 = new MyTeard();
        Thread t2 = new MyTeard2();
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(temp);
    }
}
