package common.test;

import com.sun.imageio.plugins.common.I18N;
import common.sort.Fast;
import lintcode.ListNode;
import lintcode.TreeNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
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

    public int getLength(ListNode head) {
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            cur = cur.next;
            length ++;
        }
        return length;
    }


//    public String minWindow(String s, String t) {
//
//    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        int count = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String item = queue.poll();
                char[] chars = item.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char ch = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        if (chars.toString().equals(endWord)) {
                            visited.add(chars.toString());
                            return count;
                        }
                        if (!visited.contains(chars.toString()) && wordSet.contains(chars.toString())) {
                            queue.offer(chars.toString());
                            visited.add(chars.toString());
                        }
                    }
                    chars[j] = ch;
                }
            }
            count++;
        }

        return count;
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
