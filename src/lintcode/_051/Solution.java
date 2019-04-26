package lintcode._051;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<Integer> previousPermuation(List<Integer> nums) {
        // write your code here
        int length = nums.size();
        if (length <= 1){
            return nums;
        }
        int i = length - 2;
        while ( i >= 0) {
            if (nums.get(i) < nums.get(i+1)){
                i--;
            }
        }
        if ( i < 0){
            Collections.reverse(nums);
            return nums;
        }
        int target = nums.get(i);
        for (int j = nums.size() - 1; j < i; j--) {
            if (nums.get(j) < target){
                Collections.swap(nums, i, j);
            }
        }
        Collections.reverse(nums.subList(i+1, nums.size()));

        return nums;
    }

    public static void main(String[] args) {
        /*
        1 2 3
        1 3 2
        2 1 3
        2 3 1
        3 1 2
        3 2 1
        1.从右向左历遍，找第一个升序的地方，升序说明这个位置可以变小。
        2.从找到的位置向右历遍，找到比它小的最大值与之交换。
        3.因为找到的这个位置右边都是降序的，就将这个位置右边的变为最小的排序。可简化为整体前后翻转。
         */
        Solution sol = new Solution();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        sol.previousPermuation(list);
    }
}
