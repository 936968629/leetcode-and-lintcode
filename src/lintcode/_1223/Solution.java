package lintcode._1223;

public class Solution {

    public int findSubstringInWraproundString(String p) {
        // Write your code here

        int[] dp = new int[26];
        for (int i = 0; i < 26; i++) {
            dp[i] = 0;
        }
        int length = p.length();
        int pos = 0;
        for (int i = 0; i < length; i++) {
            char c = p.charAt(i);
            if ( i>0 && p.charAt(i) - p.charAt(i-1) == 1 || (p.charAt(i) == 'a' && p.charAt(i) == 'z')) {
                pos ++;
            }else{
                pos = 1;
            }
            dp[p.charAt(i)-'a'] = Math.max( dp[p.charAt(i)-'a'], pos);
        }

        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += dp[i];
        }
        return ans;
    }


}
