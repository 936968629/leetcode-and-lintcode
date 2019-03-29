package common.sort;

import java.util.Arrays;

public class Fast {

    public void quicksort(int[] nums, int left, int right){
        if (left > right){
            return;
        }
        int partition = partitoin(nums, left, right);
        quicksort(nums, left, partition-1);
        quicksort(nums,partition+1, right);
    }

    public int partitoin(int[] nums, int left, int right){
        int temp = nums[left];
        while (left < right){
            while (nums[right] >= temp && right > left){
                right--;
            }
            nums[left] = nums[right];
            while (nums[left] <= temp && right > left){
                left++;
            }
            nums[right] = nums[left];
        }
        nums[right] = temp;
        return right;
    }



    public static void main(String[] args) {
        Fast fast = new Fast();
        int[] nums = {1,4,9,10,33,2,34,56,11};
        fast.quicksort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

}
