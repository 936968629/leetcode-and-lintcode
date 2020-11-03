package leetcode._001_100._034;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] searchRange(int[] nums, int target) {
        int[] res= new int[2];
        int length = nums.length;
        if (length == 0) {
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        int left = findLeft(nums, target);
        int right = findRight(nums, target);
        res[0] = left;
        res[1] = right;
        return res;
    }

    public int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            }else if (nums[mid] < target) {
                left = mid;
            }else {
                right = mid;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        return -1;
    }

    public int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid;
            }else if (nums[mid] < target) {
                left = mid;
            }else {
                right = mid;
            }
        }
        if (nums[right] == target) {
            return right;
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }
}
