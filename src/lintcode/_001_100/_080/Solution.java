package lintcode._001_100._080;

public class Solution {

    public int median(int[] nums) {
        // write your code here
        if ( nums.length == 0 ) {
            return 0;
        }
        int length = nums.length;
        if ( length % 2 == 0 ) {
//            int total =  findK(nums, nums.length/2, 0, nums.length - 1) + findK(nums, nums.length/2 + 1, 0, nums.length - 1);
//            return total / 2;
            return findK(nums, nums.length/2+1, 0, nums.length - 1);
        } else {
            return findK(nums, nums.length/2+1, 0, nums.length - 1);
        }

    }

    public int findK(int[] nums, int k, int left, int right) {
        int partition = partition(nums, left, right);
        if ( k-1 == partition ) {
            return nums[partition];
        }else if ( k - 1 < partition ) {
            return findK(nums, k, left, partition - 1);
        } else {
            return findK(nums, k, partition + 1, right);
        }
    }

    public int partition(int[] nums, int left, int right) {
        int flag = nums[left];
        int i = left;
        int j = right;

        while ( i <= j ) {

            while ( i <= j && nums[i] > flag ) {
                i++;
            }

            while ( i <= j && nums[j] <= flag ) {
                j--;
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
        Solution solution = new Solution();
        int[] nums = {2,3,90,1};
        int median = solution.median(nums);
        System.out.println(median);
    }
}
