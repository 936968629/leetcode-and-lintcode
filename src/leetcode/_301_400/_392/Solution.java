package leetcode._301_400._392;

public class Solution {

    public boolean isSubsequence(String s, String t) {
        int length = s.length();
        if (length == 0) {
            return true;
        }
        int sign = 0;
        for (int i = 0; i < t.length(); i++) {
            if (sign >= length){
                return true;
            }
            if (s.charAt(sign) == t.charAt(i)) {
                sign++;
            }
        }
        return false;
    }
}
