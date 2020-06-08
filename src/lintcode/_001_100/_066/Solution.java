package lintcode._001_100._066;

import lintcode.TreeNode;

import java.util.*;

public class Solution {

    private List<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
//        if ( root == null ) {
//            return result;
//        }
//        helper(root);
//        return result;
        //非递归
        if ( root == null ) {
            return result;
        }
        Stack<Command> queue = new Stack<>();
        queue.push(new Command("go", root));
        while ( !queue.isEmpty() ) {
            Command item = queue.pop();
            if ( item.behavior.equals("go") ) {
                if ( item.val.right != null ) {
                    queue.push(new Command("go", item.val.right));
                }
                if ( item.val.left != null ) {
                    queue.push(new Command("go", item.val.left));
                }
                queue.push(new Command("get", item.val));
            }else{
                result.add(item.val.val);
            }
        }
        return result;
    }

    public void helper(TreeNode root) {
        if ( root == null ) {
            return;
        }
        result.add(root.val);
        helper(root.left);
        helper(root.right);
    }

}
