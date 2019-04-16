package lintcode._101;

public class Solution {


    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums.length == 0){
            return 0;
        }

        int i = 0;
        int count = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] == nums[j]){
                count++;
                if (count >= 2){
                    continue;
                }else{
                    i++;
                    nums[i] = nums[i-1];
                }
            }else{
                i++;
                nums[i] = nums[j];
                count = 0;
            }
        }
        return i+1;
    }

}
