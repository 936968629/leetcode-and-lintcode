package common.sort;

import java.util.Arrays;

public abstract class Charu {

    public int[] sort(int[] nums){
        int length = nums.length;
        if ( length == 0 || length == 1 ) {
            return nums;
        }
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if ( nums[i] < nums[j] ) {
                    int temp = nums[i];
                    for (int k = i; k > j ; k--) {
                        nums[k] = nums[k-1];
                    }
                    nums[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        return nums;
    }
}
