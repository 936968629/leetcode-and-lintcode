package lintcode;

import lintcode._001_100._030.Interval;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Lock;

public class Test {

    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        List<Interval> result = new ArrayList<>();
        if ( intervals == null || intervals.size() == 0 ) {
            return result;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });

        for (int i = 0; i < intervals.size(); i++) {
            if ( result.size() == 0 ) {
                result.add(intervals.get(i));
            } else {
                Interval interval = intervals.get(i);
                Interval prev = result.get(result.size() - 1);
                if ( interval.start <= prev.end  ) {
                    //合并
                    prev.end = Math.max(interval.end, prev.end);
                    result.set(result.size()-1, prev);
                } else {
                    result.add(interval);
                }
            }
        }
        return result;
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // write your code here
        List<Interval> result = new ArrayList<>();
        if ( intervals == null || intervals.size() == 0 ) {
            result.add(newInterval);
            return result;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        int j = 0;
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if ( interval.end < newInterval.start ) {
                result.add(interval);
                j++;
            } else if (interval.start > newInterval.end) {
                result.add(interval);
            } else {
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            }
        }
        result.add(j, newInterval);
        return result;
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

    public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        dfs(result, nums, new ArrayList<>(), visited);
        return result;
    }

    public void dfs(List<List<Integer>> result, int[] nums, List<Integer> item, boolean[] visited) {
        if ( item.size() == nums.length ) {
            result.add(new ArrayList<>(item));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if ( visited[i] ) {
                continue;
            }
            if ( i > 0 && nums[i] == nums[i-1] && visited[i-1]) {
                continue;
            }
            item.add(nums[i]);
            visited[i] = true;
            dfs(result, nums, item, visited);
            item.remove(item.size() - 1);
            visited[i] = false;
        }
    }

    public int maxSum(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int res = nums[0];
        int[] dp = new int[length+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < length + 1; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i-1], nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
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
