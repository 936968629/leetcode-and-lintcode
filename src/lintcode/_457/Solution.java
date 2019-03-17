package lintcode._457;

import lintcode._156.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
