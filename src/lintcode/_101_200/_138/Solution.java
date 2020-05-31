package lintcode._101_200._138;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<Integer> subarraySum(int[] nums) {
        // write your code here

//        List<Integer> res = new ArrayList<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            int start = nums[i];
//            if (start == 0){
//                res.add(i);
//                res.add(i);
//                return res;
//            }
//            for (int j = i+1; j < nums.length; j++) {
//
//                if (start + nums[j] == 0){
//                    res.add(i);
//                    res.add(j);
//                    return res;
//                }else{
//                    start += nums[j];
//                }
//
//            }
//        }
//
//        return res;


        //优化
//        一个子数组的和为零，我们假设这个子数组是{ a[i], a[i+1], ..., a[j] },也就是a[i] + a[i+1] +...+ a[j] = 0,起始和结束位置其实就是i和j。那么 a[0] + a[1] +...+ a[i-1] + a[i] + a[i+1] +...+ a[j] = a[0] + a[1] +...+ a[i-1] 。把这个式子转换下，假如这个数组的前 i 项的和与前j项的和相等，那么i项到j项之间的数组的元素的和肯定是零。i，j就是需要的结果。
//        所以这个问题就转换成了求数组前n项和的问题

        List<Integer> res = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)){
                res.add(map.get(sum)+1);
                res.add(i);
                return res;
            } else{
                map.put(sum, i);
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {-3,0,2,-2,4};
        List<Integer> res = sol.subarraySum(nums);
        System.out.println(res.toString());
    }
}
