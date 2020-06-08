package lintcode._101_200._187;

public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        if (gas.length == 0 || cost.length == 0){
            return -1;
        }
        int len = gas.length;

        int totol = 0;
        int cur = 0;
        int index = -1;
        for (int i = 0; i < len; i++) {
            cur += gas[i] - cost[i];
            totol += gas[i] - cost[i];
            if (cur < 0){
                index = i;
                cur = 0;
            }
        }

        if (totol < 0){
            return -1;
        }else{
            return index + 1;
        }

    }

}
