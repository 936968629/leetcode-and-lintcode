package leetcode._201_300._295;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {

    private Queue<Integer> minHeap;
    private Queue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> {return b-a;});
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.offer(num);
            return;
        }
        if (maxHeap.peek() >= num) {
            maxHeap.offer(num);
        }else {
            minHeap.offer(num);
        }

        //调整
        if (maxHeap.size() == minHeap.size() + 2) {
            minHeap.offer(maxHeap.poll());
        }else if (minHeap.size() == maxHeap.size() + 2) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (double)(minHeap.peek() + maxHeap.peek()) / 2;
        }else if (maxHeap.size() > minHeap.size()) {
            return (double)maxHeap.peek();
        }else {
            return (double)minHeap.peek();
        }
    }

}
