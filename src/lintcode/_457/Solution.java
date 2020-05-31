package lintcode._457;

public class Solution {

    public int findPosition(int[] nums, int target) {
        // write your code here
        if (nums.length == 0){
            return -1;
        }
        int left = 0;
        int right= nums.length;

        while (left < right){

            int mid = left + (right - left) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[mid] < target){
                left = mid+1;
            }else{
                right = mid;
            }

        }
        return -1;
    }


    public static void main(String[] args) {


    }

}
