package lintcode._101_200._184;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public String largestNumber(int[] nums) {
        // write your code here
        if (nums.length == 0){
            return "";
        }
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });

        if (Integer.valueOf(strNums[0]) == 0){
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < strNums.length; i++) {
            res.append(strNums[i]);
        }

//        System.out.println(Arrays.toString(strNums));
        return res.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {1, 20, 23, 4, 8};
        String res = sol.largestNumber(nums);
        System.out.println(res);
    }
}
