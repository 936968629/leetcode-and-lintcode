package common.test;

import com.sun.imageio.plugins.common.I18N;
import common.sort.Fast;
import lintcode.ListNode;
import lintcode.TreeNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.CountDownLatch;

public class Test {

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


    public boolean exist(char[][] board, String word) {
        if (word.equals("")) {
            return true;
        }
        int rows = board.length;
        if (rows == 0) {
            return false;
        }
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (dfs(board, word, 0, rows, cols, i, j, visited)) {
                        return true;
                    }
                    visited[i][j] = false;
                }
            }
        }
        
        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int rows, int cols, int i, int j, boolean[][] visited) {
        if (word.length()-1 == index) {
            return true;
        }
        if (word.charAt(index) != board[i][j]) {
            return false;
        }

        int[][] coins = {{0, -1}, {-1, 0}, {0, 1}, {1,0}};
        for (int k = 0; k < 4; k++) {
            int newI = i + coins[k][0];
            int newJ = j + coins[k][1];
            if (newI >= 0 && newI < rows && newJ >= 0 && newJ < cols && board[newI][newJ] == word.charAt(index+1) &&
            !visited[newI][newJ]) {
                visited[newI][newJ] = true;
                if (dfs(board, word, index + 1, rows, cols, newI, newJ, visited)) {
                    return true;
                }else {
                    visited[newI][newJ] = false;
                }
            }
        }
        return false;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        
        Arrays.sort(nums);
        dfs(result, new ArrayList<>(), nums, 0, visited);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> item, int[] nums, int index, boolean[] visited) {
        if (item.size() == nums.length) {
            result.add(new ArrayList<>(item));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i-1] && visited[i-1]) {
                continue;
            }
            if (visited[i]) {
                continue;
            }
            item.add(nums[i]);
            visited[i] = true;
            dfs(result, item, nums, 0, visited);
            visited[i] = false;
            item.remove(item.size()-1);
        }
        
    }

    public ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev= cur;
            cur = next;
        }
        return prev;
    }

    public void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public int maxProfit(int[] prices) {

        return 1;
    }

    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return heights[0];
        }
        int max = 0;
        for (int i = 0; i < length; i++) {
            int leftW = i - 1;
            int rightW = i + 1;
            int width = 1;
            while (leftW >= 0 && heights[leftW] >= heights[i]) {
                leftW--;
                width++;
            }
            while (rightW <= length - 1 && heights[rightW] >= heights[i]) {
                rightW++;
                width++;
            }
            max = Math.max(max, width * heights[i]);
        }
        return max;
    }



    public static void main(String[] args) {
        CountDownLatch count = new CountDownLatch(4);
        Test test = new Test();
        int[] nusm = {1,1,3};

        System.out.println(Arrays.toString(nusm));

        List<Integer> nums = new ArrayList<>();
        String s = "abcabcbb";
        test.permuteUnique(nusm);

    }

}
