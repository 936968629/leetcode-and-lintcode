package lintcode._001_100._001;

public class Solution {

    public int aplusb(int a, int b) {
        // write your code here
        while(b != 0){
            int _a = a ^ b;
            int _b = (a & b) << 1;
            a = _a;
            b = _b;
        }
        return a;
    }

}
