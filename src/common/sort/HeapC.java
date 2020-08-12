package common.sort;

import java.util.Arrays;

public class HeapC {

    public void build(int[] nums) {
        int length = nums.length;
        for (int i = length / 2; i >= 0; i--) {
            adjust(nums, length, i);
        }
    }

    //下沉
    public void adjust(int[] nums, int length, int index) {
        int node = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < length && nums[left] < nums[node]) {
            node = left;
        }
        if (right < length && nums[right] < nums[node]) {
            node = right;
        }

        if (node != index) {
            swap(nums, node, index);
            adjust(nums, length, node);
        }
    }

    //上浮 最后一个元素
    public void upadjust(int[] nums) {
        int length = nums.length;
        int item = length-1;
        int parentIndex = (item - 1) / 2;

        int temp = nums[item];
        while (item > 0 && temp < nums[parentIndex]) {

        }
    }



    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        HeapC heapC = new HeapC();
        int[] nusm = {1,5,1,2,4,7};
        heapC.build(nusm);
        System.out.println(Arrays.toString(nusm));
    }

}
