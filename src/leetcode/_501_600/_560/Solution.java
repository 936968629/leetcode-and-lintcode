package leetcode._501_600._560;

public class Solution {

    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        int[] prefix = new int[length+1];
        prefix[0] = 0;
        prefix[1] = nums[0];

        for (int i = 2; i < length +1 ; i++) {
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        int res = 0;
        for (int i = 0; i < length + 1; i++) {
            for (int j = i+1; j < length + 1; j++) {
                if (prefix[j] - prefix[i] == k) {
                    res++;
                }
            }
        }

        return res;
    }

}
