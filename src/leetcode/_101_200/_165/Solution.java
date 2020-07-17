package leetcode._101_200._165;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public int compareVersion(String version1, String version2) {
        String[] split = version1.split("\\.");
        String[] split2 = version2.split("\\.");

        Queue<Integer> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        for (int i = 0; i < split.length; i++) {
            queue1.offer(Integer.valueOf(split[i]));
        }
        for (int i = 0; i < split2.length; i++) {
            queue2.offer(Integer.valueOf(split2[i]));
        }
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            Integer item1 = queue1.poll();
            Integer item2 = queue2.poll();
            if (item1 > item2) {
                return 1;
            }else if (item1 < item2) {
                return -1;
            }
        }
        if (queue1.size() == 0 && queue2.size() == 0) {
            return 0;
        }else if (queue1.size() > 0) {
            while (!queue1.isEmpty()) {
                Integer item = queue1.poll();
                if (item == 0) {
                }else if (item > 0) {
                    return 1;
                }
            }
            return 0;
        }else {
            while (!queue2.isEmpty()) {
                Integer item = queue2.poll();
                if (item == 0) {
                }else if (item > 0) {
                    return -1;
                }
            }
            return 0;
        }
    }

    public int compareVersion2(String version1, String version2) {
        //
        String[] split = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        while (i < split.length && j < split2.length) {
            Integer item1 = Integer.valueOf(split[i]);
            Integer item2 = Integer.valueOf(split2[i]);

        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.compareVersion("1","1.1");
    }

}
