package leetcode._201_300._207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {


    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //入度
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjacency = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        // Get the indegree and adjacency of every course.
        for(int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adjacency.get(cp[1]).add(cp[0]);
        }

        // Get all the courses with the indegree of 0.
        for(int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            numCourses--;

        }

        return true;
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
