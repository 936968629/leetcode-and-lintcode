package leetcode.jianzhiOffer._0803;

public class Solution {

    public int findMagicIndex(int[] nums) {
        int length = nums.length;
        if ( length == 0 ) {
            return -1;
        }
        for (int i = 0; i < length; i++) {
            if ( nums[i] == i ){
                return i;
            }
        }
        return -1;
    }

}
