package lintcode._005;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public int kthLargestElement(int n, int[] nums) {
        // write your code here


//        int start=0;
//        int end=nums.length-1;
//        int index=partition(nums, 0, nums.length-1);
//        while(index!=nums.length-n){
//            if(index>nums.length-n){
//                index=partition(nums, start, index-1);
//            }else{
//                index=partition(nums, index+1, end);
//            }
//        }
//        return nums[index];


        int length = nums.length;
        if (n > length){
            return new Integer(null);
        }
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
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

    public int partition(int[] nums,int start,int end){
        int flag = nums[start];
        while (start < end){
            while (nums[end] > flag && end > start){
                end --;
            }

            while (nums[start] < flag && end > start){
                start++;
            }

        }
        return end;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int n = 1;
        int[] nums = {1,3,4,2,1};
        sol.kthLargestElement(n, nums);
    }

}
