package leetcode._501_600._501;

import lintcode.TreeNode;

import java.util.LinkedList;

public class Solution {

    private Integer cur = Integer.MIN_VALUE;
    private Integer count = 0;
    private Integer max = 0;

    private LinkedList<Integer> list = new LinkedList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        int val = root.val;
        if (val == cur) {
            count++;
        }else {
            count = 0;
            cur = val;
        }

        if (count == max) {
            list.add(val);
        }else if (count > max) {
            list.clear();
            list.add(val);
            max = count;
        }

        inorder(root.right);
    }

}
