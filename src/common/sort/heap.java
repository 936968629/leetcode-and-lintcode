package common.sort;

import java.util.Arrays;

public class heap {

    public void heapSort(int[] nums){
        if ( nums == null || nums.length ==0 ) {
            return;
        }
        int length = nums.length;
        buildHeap(nums, length);
        for (int i = length - 1; i > 0 ; i--) {
            swap(nums, 0, i);
            length -= 1;
            adjust(nums, 0, length);
        }
        System.out.println(Arrays.toString(nums));
    }

    private void buildHeap(int[] nums, int length) {
        for (int i = length / 2; i >= 0 ; i--) {
            adjust(nums, i, length);
        }
    }

    private void adjust(int[] nums, int i, int length) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int lastest = i;

        if ( left < length && nums[left] > nums[lastest] ) {
            lastest = left;
        }
        if ( right < length && nums[right] > nums[lastest] ) {
            lastest = right;
        }

        if ( lastest != i ) {
            swap(nums, i, lastest);
            adjust(nums, lastest, length);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] nums = {49,38,65,97,76,13,27,49,1};
        heap heap = new heap();
        heap.heapSort(nums);
    }
}
