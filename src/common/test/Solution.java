package common.test;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Solution {

    public void fastSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int start, int end) {
//        if (start >= end) {
//            return;
//        }
        if (start < end) {
            int index = partition(nums, start, end);
            quickSort(nums, start, index-1);
            quickSort(nums, index+1, end);
        }
        
    }

    public int partition(int[] nums, int left, int right) {
        int flag = nums[left];
        int i = left;
        int j = right;
        while ( i <= j) {
            while ( i <= j && nums[i] <= flag) {
                i++;
            }
            while ( i <= j && nums[j] > flag) {
                j--;
            }
            if ( i <= j ) {
                swap(nums, i, j);
                i++;
                j--;
            }

        }

        swap( nums, j, left);
        return j;
    }

    public void heapSort(int[] nums) {

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        sol.fastSort(nums);
        System.out.println(Arrays.toString(nums));

    }

}
