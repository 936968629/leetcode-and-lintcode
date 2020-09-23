package leetcode._201_300._263;

public class Solution {

    public boolean isUgly(int num) {

        while (num > 1) {
            if (num % 2 == 0) {
                num = num / 2;
            }else if (num % 3 == 0) {
                num = num / 3;
            }else if (num % 5 == 0) {
                num = num / 5;
            }else {
                return false;
            }
        }
        return num == 1;
    }

}
