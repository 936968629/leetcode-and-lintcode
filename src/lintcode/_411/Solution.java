package lintcode._411;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> grayCode(int n) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        res.add(0);
        if(n == 0){
            return res;
        }
        for (int i = 1; i < 1 << n; i++) {
            res.add(i ^ i >> 1);
        }
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.grayCode(10);
    }

}
