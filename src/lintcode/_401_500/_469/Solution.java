package lintcode._401_500._469;

import lintcode.TreeNode;

public class Solution {

    public boolean isIdentical(TreeNode a, TreeNode b) {
        // write your code here
        if ( a == null && b == null ) {
            return true;
        }

        if ( a!= null && b!=null && a.val == b.val ) {

            return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);

        }
        return false;
    }

}
