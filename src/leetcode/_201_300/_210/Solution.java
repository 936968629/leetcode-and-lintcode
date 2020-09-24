package leetcode._201_300._210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        //[[1,0],[2,0],[3,1],[3,2]]
        int[] ingree = new int[numCourses];
        List<List<Integer>> gens = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            gens.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int[] item = prerequisites[i];
            ingree[item[0]]++;
            gens.get(item[1]).add(item[0]);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (ingree[i] == 0) {
                queue.addLast(i);
            }
        }

        int j = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.pollFirst();
            res[j] = poll;
            List<Integer> list = gens.get(poll);
            for (int item : list) {
                ingree[item]--;
                if (ingree[item] == 0) {
                    queue.addLast(item);
                }
            }
            j++;
        }
        if (j != numCourses) {
            return new int[0];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[][] nums = {{1,0},{2,0},{3,1},{3,2}};
        int[][] nums = {{0,1}};
        solution.findOrder(2, nums);
    }
}
