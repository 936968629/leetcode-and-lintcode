package leetcode.jianzhiOffer._026;

import lintcode.TreeNode;

public class Solution {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        }
        if (A == null || B == null) {
            return false;
        }

        return helper(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);

    }

    public boolean helper(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        if (s.val == t.val) {
            return helper(s.left, t.left) && helper(s.right, t.right);
        }
        return false;
    }

}
