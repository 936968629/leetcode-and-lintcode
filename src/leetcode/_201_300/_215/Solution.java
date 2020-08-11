package leetcode._201_300._215;

public class Solution {

    public int findKthLargest(int[] nums, int k) {
        if(nums.length < k || k== 0) {
            return  -1;
        }
        return find(nums, 0, nums.length - 1, k);
    }

    public int find(int[] nums, int start, int end, int k) {
        int index = partition(nums,start, end);
        if (k - 1 == index) {
            return nums[index];
        }else if (k - 1 > index) {
            return find(nums, index + 1, end, k);
        }else {
            return find(nums, start, index-1, k);
        }

    }

    public int partition(int[] nums, int start, int end) {
        int signal = nums[start];
        int i = start + 1;
        int j = end;

        while (i <= j) {

            while (i <= j && nums[i] > signal) {
                i++;
            }
            while (i <= j && nums[j] <= signal) {
                j--;
            }

            if (i < j) {
                swap(nums, i, j);
            }
        }

        swap(nums, start, j);
        return j;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,1,2,4};
        System.out.println(solution.findKthLargest(nums, 4));
    }
}
