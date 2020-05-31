package lintcode._480;

import lintcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here

        List<String> result = new ArrayList<>();
        if ( root == null ) {
            return result;
        }
        dfs("", root, result);
        return result;
    }

    public void dfs(String item, TreeNode root, List<String> result) {
        if ( root.left == null && root.right == null ) {
            item += root.val;
            result.add(item);
            return;
        }
        item =item + root.val + "->";
        if ( root.left != null ) {
            dfs(item, root.left, result);
        }
        if ( root.right != null ) {
            dfs(item, root.right, result);
        }

    }

}
