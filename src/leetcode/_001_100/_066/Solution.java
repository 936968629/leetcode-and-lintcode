package leetcode._001_100._066;

public class Solution {

    public int[] plusOne(int[] digits) {
        int length = digits.length;
        if (length == 0) {
            return null;
        }
        int signal = 1;
        reverse(digits);
        int i = 0;
        while (i < length) {
            int temo = digits[i] + signal;
            if (temo >= 10) {
                temo = temo % 10;
                signal = 1;
            }else {
                signal = 0;
            }
            digits[i] = temo;
            i++;
        }
        if (signal == 1) {
            int[] res = new int[length +1];
            for (int j = 0; j < length; j++) {
                res[j] = digits[j];
            }
            res[length]  = 1;
            reverse(res);
            return res;
        }else {
            reverse(digits);
            return digits;
        }
    }

    public void reverse(int[] digits) {
        int i = 0;
        int j = digits.length -1;
        while (i<=j){
            swap(digits, i, j);
            i++;
            j--;
        }
    }

    public void swap(int[] digits, int i, int j) {
        int temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }

}
