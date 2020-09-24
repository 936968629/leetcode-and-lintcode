package leetcode.jianzhiOffer._005;

public class Solution {

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        int length = s.length();
        if (length == 0) {
            return "";
        }
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

}
