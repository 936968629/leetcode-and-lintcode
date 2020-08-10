package leetcode._001_100._058;

public class Solution {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int length = s.length();
        if (length == 0) {
            return 0;
        }

        int res = -1;
        for (int i = length-1; i >=0 ; i--) {
            if (s.charAt(i) == ' ') {
                res = length - i - 1;
                break;
            }
        }
        return res == -1 ? length:res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lengthOfLastWord("    ");
    }

}
