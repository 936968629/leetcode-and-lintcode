package lintcode._363;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int trapRainWater(int[] heights) {
        // write your code here
        int length = heights.length;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        System.out.println(list.get(2));
        return 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] height = {1,2,3,4};
        sol.trapRainWater(height);
    }

}
