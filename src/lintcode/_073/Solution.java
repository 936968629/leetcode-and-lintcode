package lintcode._073;

import lintcode.TreeNode;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if(preorder.length == 0){
            return null;
        }
        return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    public TreeNode build(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend){

        if (prestart > preend || instart > inend){
            return null;
        }
        int sign = findArray(inorder, preorder[prestart]);
        int len = sign - instart; //左子树的长度
        TreeNode root = new TreeNode(preorder[prestart]);
        root.left = build(preorder, prestart+1, prestart+len, inorder, instart, sign-1);
        root.right = build(preorder, prestart+len+1, preend, inorder, sign+1, inend);
        return root;
    }


    public int findArray(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        1
//        2 3
//        4 5 6 7
        //1,2,4,5,3,6,7
        //4,2,5,1,6,3,7
        Solution sol = new Solution();
        int[] preorder = {1,2,4,5,3,6,7};
        int[] inorder = {4,2,5,1,6,3,7};
        TreeNode tree = sol.buildTree(preorder, inorder);
        System.out.println(tree.toString());
    }
}
