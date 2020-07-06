package leetcode._101_200._167;

public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int length = numbers.length;
        if (length == 0) {
            res[0] = res[1] = -1;
            return res;
        }
        int i = 0;
        int j = length - 1;
        while (i < j) {
            int num = numbers[i] + numbers[j];
            if (num == target) {
                res[0] = i+1;
                res[1] = j+1;
                return res;
            }else if (num > target) {
                j--;
            }else {
                i++;
            }
        }
        res[0] = res[1] = -1;
        return res;
    }

}
