package lintcode._376;

import lintcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List res = new ArrayList<>();
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here
        if ( root == null) {
            return res;
        }
        List<Integer> result = new ArrayList<>();
        dfs(root,result,0,target);
        return res;
    }

    public void dfs(TreeNode root, List<Integer> result,int current,int target){
        current += root.val;
        result.add(root.val);
        if (root.left == null && root.right == null) {
            if ( current == target ) {
                res.add(new ArrayList<>(result));
            }
            return;
        }
        if ( root.left != null ) {
            dfs(root.left, result, current, target);
            result.remove(result.size() - 1);
        }
        if ( root.right != null) {
            dfs(root.right, result, current, target);
            result.remove(result.size() - 1);
        }
    }

}
