package leetcode.jianzhiOffer._019;

public class Solution {

    public boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();

        boolean[][] dp = new boolean[sLength+1][pLength+1];
        dp[0][0] = true;
        for (int i = 1; i < pLength + 1; i++) {
            if (p.charAt(i-1) == '*' && dp[0][i-2]) {
                dp[0][i] = true;
            }
        }

        for (int i = 1; i < sLength + 1; i++) {
            for (int j = 1; j < pLength + 1; j++) {
                if (s.charAt(i-1) == p.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    if (p.charAt(j-1) == '.') {
                        dp[i][j] = dp[i-1][j-1];
                    }else if (p.charAt(j-1) == '*') {
                        if(j>=2){
                            char nowpLast = p.charAt(j-2);
                            //只有p[j-2]==s[i-1]或p[j-2]==‘.’才可以让*取1个或者多个字符：
                            if(nowpLast==s.charAt(i-1) || nowpLast=='.')
                                dp[i][j] = dp[i-1][j] || dp[i][j-1];

                            //不论p[j-2]是否等于s[i-1]都可以删除掉j-1和j-2处字符：
                            dp[i][j] = dp[i][j]||dp[i][j-2];
                        }

                    }
                }
            }
        }

        return dp[sLength][pLength];
    }

}
