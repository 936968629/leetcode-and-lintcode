package lintcode._001_100._067;

import lintcode.TreeNode;
import lintcode._001_100._066.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if ( root == null ) {
            return result;
        }
        Stack<Command> stack = new Stack<>();
        stack.push(new Command("go", root));
        while ( !stack.empty() ) {
            Command item = stack.pop();
            if ( item.behavior.equals("go") ) {
                if ( item.val.right != null ) {
                    stack.push(new Command("go", item.val.right));
                }
                stack.push(new Command("get", item.val));
                if ( item.val.left != null ) {
                    stack.push(new Command("go", item.val.left));
                }
            }else{
                result.add(item.val.val);
            }
        }
        return result;
    }

}
