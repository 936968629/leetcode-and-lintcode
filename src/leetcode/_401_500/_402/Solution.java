package leetcode._401_500._402;

public class Solution {

    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        StringBuilder res = new StringBuilder(num);
        for (int i = 0; i < k; i++) {
            int idx = 0;
            for (int j = 1; j < res.length() && res.charAt(j) >= res.charAt(j-1); j++) {
                idx = j;
            }
            res.delete(idx, idx+1);
            while (res.length() > 0 && res.charAt(0) == '0') {
                res.delete(0,1);
            }
        }
        return res.length() == 0 ? "0" : res.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.removeKdigits("10200", 1);
        System.out.println(s);
    }
}
