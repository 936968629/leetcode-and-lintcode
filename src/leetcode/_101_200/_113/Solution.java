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
        dfs(result, new ArrayList<>(), 0, root, sum);
        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> item, int target, TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            if (target + root.val == sum) {
                item.add(root.val);
                result.add(new ArrayList<>(item));
                item.remove(item.size() - 1);
                return;
            }
            return;
        }

        if (root.left != null) {
            target = target + root.val;
            item.add(root.val);
            dfs(result, item, target, root.left, sum);
            target = target - root.val;
            item.remove(item.size() - 1);
        }
        if (root.right != null) {
            target = target + root.val;
            item.add(root.val);
            dfs(result, item, target, root.right, sum);
            target = target - root.val;
            item.remove(item.size() - 1);
        }

    }
}
