package lintcode._147;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> getNarcissisticNumbers(int n) {
        // write your code here

        List<Integer> res = new ArrayList<>();
        if ( n == 1){
            res.add(0);
        }
        int lowet = (int) Math.pow( 10, n-1);
        int high = (int) Math.pow(10, n);
        for (int i= lowet; i<high;i++){
            Integer _i = new Integer(i);
            char[] str = _i.toString().toCharArray();
            int result = 0;
            for (int j=0;j<str.length;j++){
                int temp = (int) Math.pow(Integer.parseInt(""+str[j]), n);
                result += temp;
            }
            if (result == i){
                res.add(i);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        BigDecimal big = new BigDecimal(Math.PI).setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(big);
        List<Integer> res = new ArrayList<>();
        res = sol.getNarcissisticNumbers(5);

        System.out.println(res);
    }
}
