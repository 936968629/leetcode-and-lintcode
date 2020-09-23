package leetcode._401_500._486;

public class Solution {

    class Command {
        public int first;
        public int sec;

        public Command(int first, int sec) {
            this.first = first;
            this.sec = sec;
        }
    }

    public boolean PredictTheWinner(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return true;
        }
        // dp  i到j  first先选最大  sec后选最大 
        Command[][] dp = new Command[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = new Command(nums[i], 0);
        }

        for (int i = length - 2; i >= 0 ; i--) {
            for (int j = i+1; j < length; j++) {
                // 先手 选左边
                int leftNum = nums[i] + dp[i+1][j].sec;
                // 先手选右边
                int rightNum = nums[j] + dp[i][j-1].sec;
                if (leftNum > rightNum) {
                    //选左
                    dp[i][j] = new Command(leftNum, dp[i+1][j].first);
                }else {
                    dp[i][j] = new Command(rightNum, dp[i][j-1].first);
                }

            }
        }

        return dp[0][length-1].first >= dp[0][length-1].sec;
    }

}
