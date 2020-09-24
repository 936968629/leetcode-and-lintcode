package leetcode._101_200._105;

import lintcode.TreeNode;

public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;
        if (preLen == 0 || inLen == 0) {
            return null;
        }
        return build(preorder, 0, preLen - 1, inorder, 0, inLen - 1);
    }

    //前序遍历 preorder = [3,9,20,15,7]
    //中序遍历 inorder = [9,3,15,20,7]
    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = find(inorder, preorder[preStart]);
        int len = index - inStart;//left Len
        root.left = build(preorder, preStart + 1, preStart + len, inorder, inStart, index-1);
        root.right = build(preorder, preStart + len + 1, preEnd, inorder, index+1, inEnd);
        return root;
    }

    public int find(int[] inorder, int target) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
