package leetcode._201_300._233;

public class Solution {

    public int countDigitOne(int n) {
        int res = 0;
        for (int i = 1; i <= n ; i++) {
            int ietem = i;
            while (ietem > 0) {
                int mod = ietem % 10;
                if (mod == 1) {
                    res++;
                }
                ietem = ietem / 10;
            }
        }
        return res;
    }

}
