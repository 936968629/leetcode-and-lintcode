package leetcode._501_600._572;

import lintcode.TreeNode;

public class Solution {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s== null || t == null) {
            return false;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t) || helper(s, t);
    }

    public boolean helper(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s== null || t == null) {
            return false;
        }
        if (s.val == t.val) {
            return helper(s.left, t.left) && helper(s.right, t.right);
        }
        return false;
    }

}
