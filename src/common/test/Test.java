package common.test;

import com.sun.imageio.plugins.common.I18N;
import common.sort.Fast;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Test {

    public void buildHeap(int[] nums) {
        int length = nums.length;
        //大顶堆
        for (int i = length / 2; i >= 0 ; i--) {
            adjust(nums, i, length);
        }
    }

    public void adjust(int[] nums, int i, int length) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;

    }

    public void quickSort(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return;
        }
        fastSort(nums, 0, length-1);
    }

    public void fastSort(int[] nums, int start, int end) {
        if (start < end) {
            int index = partition(nums, start, end);
            fastSort(nums, start, index-1);
            fastSort(nums, index+1, end);
        }
    }

    public int partition(int[] nums, int start, int end) {
//        int signal = nums[start];
        int signal = getMid(nums, start, end);
        int i = start + 1;
        int j = end;

        while (i <= j) {
            while (i <= j && nums[i] <= signal) {
                i++;
            }
            while (i <= j && nums[j] > signal) {
                j--;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }

        swap(nums, j ,start);
        return j;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int getMid(int[] nums, int start, int end) {
        int mid = start + (end - start) / 2;
        if (nums[start] > nums[end]) {
            swap(nums, start, end);
        }
        if (nums[mid] > nums[end]) {
            swap(nums, mid, end);
        }
        if (nums[start] > nums[mid]) {
            swap(nums, start, mid);
        }
        return nums[start];
    }

    public void maopao(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (nums[j] > nums[j+1]) {
                    swap(nums, j, j+1);
                }
            }
        }
    }



    public static void main(String[] args) {

        Test test = new Test();
        int[] nusm = {1,5,1,2,4,7};
//        test.buildHeap(nusm);
//        test.quickSort(nusm);
        test.maopao(nusm);
        System.out.println(Arrays.toString(nusm));

        List<Integer> nums = new ArrayList<>();

    }

}
