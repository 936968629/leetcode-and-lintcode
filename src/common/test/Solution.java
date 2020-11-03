package common.test;

import java.math.BigDecimal;
import lintcode.ListNode;
import lintcode.TreeNode;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Solution {

    public void fastSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int start, int end) {
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

    public int countSubstrings(String s) {
        int length = s.length();
        if (length == 0) {
            return 1;
        }
        int res = 0;
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
            res++;
        }

        for (int i = length - 2; i >= 0 ; i--) {
            for (int j = i+1; j < length; j++) {
                if (s.charAt(i) == s.charAt(j) && (dp[i+1][j-1] || j-i < 2)) {
                    dp[i][j] = true;
                    res++;
                }
            }
        }
        return res;

    }

    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }

        int left = 0;
        int right = length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid;
            }else if (nums[mid] > target) {
                right = mid;
            }else {
                left = mid;
            }
        }
        if ( nums[left] >= target ){
            return left;
        }
        if ( nums[right] >= target ){
            return right;
        }
        return length;
    }

//    public ListNode rotateRight(ListNode head, int k) {
//
//    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        StringBuilder sb = new StringBuilder();
        StringBuffer sb1 = new StringBuffer();
        sb.append("sda");
        sol.fastSort(nums);
        System.out.println(Arrays.toString(nums));

    }

}
