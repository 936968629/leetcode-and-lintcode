package lintcode._001_100._051;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class Solution {

    public List<Integer> previousPermuation(List<Integer> nums) {
        // write your code here
        int length = nums.size();
        if (length <= 1){
            return nums;
        }
        int i = length - 1;
        while ( i > 0 ) {
            if ( nums.get(i) < nums.get(i-1) ) {
                break;
            }
            i--;
        }

        if ( i == 0 ) {
            reverse(nums, 0, length - 1);
            return nums;
        }
        // i> 0
        int j = length - 1;
        while ( nums.get(i-1) <= nums.get(j) ) {
            j--;
        }
        swap(nums, i-1, j);
        reverse(nums, i, length -1 );
        return nums;
    }

    public void reverse(List<Integer> nums, int start, int end) {
        while ( start < end ) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    public void swap(List<Integer> nums, int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
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
//        ConcurrentSkipListSet
        ConcurrentSkipListMap map = new ConcurrentSkipListMap();

        Solution sol = new Solution();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        sol.previousPermuation(list);
    }
}
