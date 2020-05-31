package lintcode._101_200._107;

import java.util.Set;

public class Solution {

    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here

        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;


        for(int i = 0; i< len; i++){
            if(!dp[i])
                continue;

            for(String current : dict){
                int clen = current.length();
                int end = i + clen;

                if(end > len) continue;

                if(dp[end]) continue;

                if(s.substring(i , end).equals(current)){
                    dp[end] = true;
                }
            }
        }
        return dp[len];
    }

}
