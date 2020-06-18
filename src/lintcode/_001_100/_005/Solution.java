package lintcode._001_100._005;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public int kthLargestElement(int n, int[] nums) {
        // write your code here
        int length = nums.length;
        if (n > length){
            return 0;
        }
        //升序
        Queue<Integer> queue = new PriorityQueue<>(n);
        for (int i = 0; i < length; i++) {
            if (i < n){
                queue.offer(nums[i]);
            } else {
                if (nums[i] > queue.peek()){
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }
        return queue.peek();
    }

    public int kthLargestElement2(int n, int[] nums) {
        if ( nums.length == 0 || n == 0) {
            return 0;
        }
        return findK(nums, n, 0, nums.length-1);
    }

    public int findK(int[] nums, int k, int start, int end) {
        int partition = partition(nums, start, end);
        if ( k-1 == partition ) {
            return nums[partition];
        } else if ( k-1 < partition ) {
            return findK(nums,k,start, partition-1);
        } else {
            return findK(nums,k,partition+1, end);
        }

    }


    public int partition(int[] nums,int start,int end){
        int flag = nums[start];
        int i = start;
        int j = end;
        while ( i <= j ) {

            while ( i <= j && nums[j] <= flag  ) {
                j--;
            }
            while ( i <= j && nums[i] > flag ) {
                i++;
            }
            if ( i < j ) {
                swap(nums, i, j);
            }

        }
        return i;
    }

    public void swap(int[] nums, int i , int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 1;
        int[] nums = {1,3,4,2,1};
//        sol.kthLargestElement(n, nums);
        int i = sol.kthLargestElement2(n, nums);
        System.out.println(i);
    }

}
