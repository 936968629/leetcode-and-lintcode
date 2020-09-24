package leetcode._001_100._038;

public class Solution {

    /**
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String prev = countAndSay(n - 1);
        StringBuffer res = new StringBuffer();
        int count = 1;
        for (int i = 0; i < prev.length(); i++) {
            if (i < prev.length() - 1 && prev.charAt(i) == prev.charAt(i+1)) {
                count++;
            }else {
                res.append(count).append(prev.charAt(i));
                count = 1;
            }
        }

        return res.toString();
    }

}
