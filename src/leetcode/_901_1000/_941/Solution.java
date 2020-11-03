package leetcode._901_1000._941;

import java.util.Timer;
import java.util.TimerTask;

public class Solution {

    public boolean validMountainArray(int[] A) {
        int length = A.length;
        if (length <= 2) {
            return false;
        }
        int max = Integer.MIN_VALUE;
        int index = -1;
        for (int i = 0; i < length; i++) {
            if (A[i] > max) {
                max = A[i];
                index = i;
            }
        }
        if (index == 0 || index == length - 1) {
            return false;
        }

        for (int i = 0; i < index - 1; i++) {
            if (A[i] < A[i+1]) {
            }else {
                return false;
            }
        }

        for (int i = index; i < length - 1; i++) {
            if (A[i] > A[i+1]) {
            }else {
                return false;
            }
        }

        return true;
    }

    static class MyTask extends TimerTask{

        @Override
        public void run() {
            System.out.println(1);
        }
    }

    public static void main(String[] args) {
        Timer timer = new Timer();
        MyTask myTask = new MyTask();
        timer.schedule(myTask, 3000, 1000);
    }
}
