package lintcode._301_400._379;

import java.util.*;

public class Solution {

    public String minNumber(int[] nums) {
        // write your code here

        int n = nums.length;
        if (n == 0) {
            return "";
        }

        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String ab = a.concat(b);
                String ba = b.concat(a);
                return ba.compareTo(ab);
            }
        });

        String ans = "";
        // 从大到小排列后，要求最小数必须从末尾开始取值拼接
        for (int i = n - 1; i >= 0; i--) {
            ans = ans.concat(strs[i]);
        }

        // 输入数字一部分为 0 的情况
        int i = 0;
        while (i < n && ans.charAt(i) == '0') {
            i++;
        }

        // 输入数字全部为 0 的情况
        if (i == n) {
            return "0";
        }
        return ans.substring(i);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {3, 32, 321,1,0,90};

        Map<String, Integer> map = new Hashtable<>();
        List list = new ArrayList();
        list.add(2);
        String res = sol.minNumber(nums);
        System.out.println(res);
    }

}
