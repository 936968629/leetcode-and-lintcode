package leetcode._101_200._106;

import lintcode.TreeNode;

public class Solution {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int inLen = inorder.length;
        int poLen = postorder.length;
        if (inLen == 0 || poLen == 0) {
            return null;
        }
        return build(inorder, 0, inLen - 1, postorder, 0, poLen-1);
    }

    //中序遍历 inorder = [9,3,15,20,7]
    //后序遍历 postorder = [9,15,7,20,3]
    public TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = find(inorder, postorder[postEnd]);
        int leftLen = index - inStart;
        root.left = build(inorder, inStart, index-1, postorder, postStart, postStart+leftLen-1);
        root.right = build(inorder, index + 1, inEnd, postorder, postStart + leftLen, postEnd-1);
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
