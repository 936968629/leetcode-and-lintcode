package leetcode._101_200._113;

import lintcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(result, new ArrayList<>(), root, sum);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> item, TreeNode root, int target) {
        if (root.left == null && root.right == null) {
            target = target - root.val;
            item.add(root.val);
            if (target == 0) {
                result.add(new ArrayList<>(item));
            }
            target += root.val;
            item.remove(item.size()-1);
            return;
        }
        item.add(root.val);
        target -= root.val;
        if (root.left != null) {
            dfs(result, item, root.left, target);
        }
        if (root.right != null) {
            dfs(result, item, root.right, target);
        }
        item.remove(item.size()-1);
        target += root.val;
    }
}
