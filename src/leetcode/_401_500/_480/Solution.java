package leetcode._401_500._480;

import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {

    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new double[]{};
        }
        double[] res = new double[nums.length - k + 1];
        Queue<Double> minHeap = new PriorityQueue<>();
        Queue<Double> maxHeap = new PriorityQueue<>((a,b) -> {return Double.compare(b,a);});

        int l = 0;
        int r = 0;

        int count = 0;
        int index = 0;

        while (r < nums.length) {
            int item = nums[r];
            if (count < k - 1) {
                add(minHeap, maxHeap, (double)item);
                count++;
            }else {
                add(minHeap, maxHeap, (double)item);
                if (maxHeap.size() == minHeap.size()) {
                    res[index] = (double) (maxHeap.peek() + minHeap.peek()) / 2;
                }else if (maxHeap.size() > minHeap.size()){
                    res[index] = (double)maxHeap.peek();
                }else {
                    res[index] = (double)minHeap.peek();
                }
                index++;
                int leftItem = nums[l];
                l++;
                remove(minHeap, maxHeap, (double) leftItem);
            }
            r++;
        }
        return res;
    }

    public void add(Queue<Double> minHeap, Queue<Double> maxHeap, double num) {
        maxHeap.offer((double)num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public void remove(Queue<Double> minHeap, Queue<Double> maxHeap, double num) {
        if (num <= maxHeap.peek()) {
            maxHeap.remove(num);
        } else {
            minHeap.remove(num);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        solution.medianSlidingWindow(nums, 3);
    }
}
