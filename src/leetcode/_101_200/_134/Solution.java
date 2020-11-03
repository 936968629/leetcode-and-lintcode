package leetcode._101_200._134;

public class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = 0;
        int sumCost = 0;
        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
        }
        if (sumCost > sumGas) {
            return -1;
        }
        
        int index = -1;
        int space = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < gas.length; i++) {
            space += gas[i] - cost[i];
            if (space < min) {
                index = i;
                min = space;
            }
        }
        return (index + 1) % gas.length;
    }

}
