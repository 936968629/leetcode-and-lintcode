package lintcode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;

public class Test {

    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] res = new int[2];
        if ( numbers.length == 0 ) {
            return res;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if ( map.containsKey(numbers[i]) ) {
                res[0] = map.get(numbers[i]);
                res[1] = i;
                return res;
            } else {
                map.put(target-numbers[i], i);
            }
        }
        return res;
    }
    //三数之和
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(numbers);
        dfs(numbers, 0, new ArrayList<>(), res);
        return res;
    }

    public void dfs(int[] numbers, int index, List<Integer> item, List<List<Integer>> res) {
        if ( item.size() == 3 && item.get(0) + item.get(1) + item.get(2) == 0 ) {
            res.add(new ArrayList<>(item));
            return;
        }
        if ( item.size() == 3 ) {
            return;
        }
        for (int i = index; i < numbers.length; i++) {
            if ( i > index && numbers[i] == numbers[i-1] ) {
                continue;
            }
            item.add(numbers[i]);
            dfs(numbers, i+1, item, res);
            item.remove(item.size()-1);
        }
    }

    public String minNumber(int[] nums) {
        // write your code here
        int length = nums.length;
        StringBuilder sb = new StringBuilder();
        if ( length == 0 ) {
            return "";
        }
        String[] str = new String[length];
        for (int i = 0; i < length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String ab = o1+o2;
                String ba = o2+o1;
                return ba.compareTo(ab);
            }
        });
        System.out.println(Arrays.toString(str));
        for (int i = length-1; i >= 0; i--) {
            sb.append(str[i]);
        }
        // 输入数字一部分为 0 的情况
        int i = 0;
        while (i < length && sb.charAt(i) == '0') {
            i++;
        }

        // 输入数字全部为 0 的情况
        if (i == length) {
            return "0";
        }
        return sb.substring(i);
    }

    public static void main(String[] args) {
        Test test = new Test();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        Integer[] nums = {1,3,10,4,9,100,45,22,11,3,1,3,10,4,9,100,45,22,11,3,1,3,10,4,9,100,45,22,11,3,1,3,10,4,9,100,45,22,11,3,1,3,10,4,9,100,45,22,11,3};
        int[] coins = {2,3,8};

        Arrays.sort(nums, null);
        int[] te = {3, 32, 321, 0};
        System.out.println(test.minNumber(te));
    }

}
