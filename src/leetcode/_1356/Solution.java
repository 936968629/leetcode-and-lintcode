package leetcode._1356;

import java.util.Arrays;

public class Solution {

    public int[] sortByBits(int[] arr) {
        int[] map = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            map[i] = Integer.bitCount(arr[i]) * 1000000 + arr[i];
        }

        Arrays.sort(map);
        for (int i = 0; i < arr.length; i++) {
            map[i] = map[i] % 1000000;
        }

        return map;
    }

}
