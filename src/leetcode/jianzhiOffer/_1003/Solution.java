package leetcode.jianzhiOffer._1003;

public class Solution {

    public int search(int[] arr, int target) {
        int length = arr.length;
        if (length == 0) {
            return -1;
        }
        for (int i = 0; i < length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
