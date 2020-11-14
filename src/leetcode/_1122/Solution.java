package leetcode._1122;

public class Solution {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] answer = new int[arr1.length];
        int[] count = new int[1001];

        for (int i = 0; i < arr1.length; i++) {
            count[arr1[i]] = count[arr1[i]] + 1;
        }


    }

}
