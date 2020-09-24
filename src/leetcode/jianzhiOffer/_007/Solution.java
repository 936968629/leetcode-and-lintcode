package leetcode.jianzhiOffer._007;

import lintcode.TreeNode;

public class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLength = preorder.length;
        int inLength = inorder.length;
        if (preLength == 0) {
            return null;
        }
        return build(preorder, 0, preLength - 1, inorder, 0, inLength - 1);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd ) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = find(inorder, preorder[preStart]);
        int len = index - inStart;//左子树长度
        root.left = build(preorder, preStart + 1, preStart + len, inorder, inStart, index - 1);
        root.right = build(preorder, preStart + len + 1, preEnd, inorder, index+1, inEnd);
        return root;
    }

    public int find(int[] inorder, int target) {
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }
        return 0;
    }
}
