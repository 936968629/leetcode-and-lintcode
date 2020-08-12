package leetcode._201_300._207;

import java.util.*;

public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] ingree = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        int rows = prerequisites.length;
        for (int i = 0; i < rows; i++) {
            ingree[prerequisites[i][0]] ++;
            adjacency.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }


        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (ingree[i] == 0) {
                queue.add(i);
            }
        }
        int courseNum = numCourses;
        while (!queue.isEmpty()) {
            Integer item = queue.removeFirst();
            courseNum--;
            for (int idx : adjacency.get(item)) {
                ingree[idx]--;
                if (ingree[idx] == 0) {
                    queue.addLast(idx);
                }
            }
        }
        return courseNum == 0;
    }

    public static void main(String[] args) {
//        2, [[1,0],[0,1]]
        Solution solution = new Solution();
        int[][] nums = {
                {1,0},
                {1,2}
        };
        solution.canFinish(3, nums);
    }

}
