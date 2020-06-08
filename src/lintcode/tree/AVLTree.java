package lintcode.tree;

import lintcode.TreeNode;

public class AVLTree {

    public TreeNode insertNode(TreeNode root, int val) {
        if ( root == null ) {
            return new TreeNode(val);
        }
        if ( val < root.val ) {
            root.left = insertNode(root.left, val);
        } else if (val > root.val) {
            root.right = insertNode(root.right, val);
        } else {
            return root;
        }
        //左子树 - 右子树
        int balanced = isBalanced(root);
        if ( balanced > 1 && val < root.left.val ) {
            return rightRotate(root);
        }
        //先左旋 右旋
        if ( balanced > 1 && val > root.right.val ) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        if ( balanced < -1 && val > root.right.val ) {
            return leftRotate(root);
        }

        if ( balanced < -1 && val < root.right.val ) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    public TreeNode deleteNode() {


        return null;
    }


    /**
     *      z
     *    y     t4
     *  x  t3
     *t1 t2
     */
    public TreeNode rightRotate(TreeNode y) {
        TreeNode x = y.left;
        TreeNode xRight = x.right;

        x.right = y;
        y.left = xRight;
        return x;
    }

    /**
     *       z
     *    t1   y
     *       t2  x
     *         t3 t4
     */
    public TreeNode leftRotate(TreeNode y) {
        TreeNode x = y.right;
        TreeNode t3 = x.left;
        x.left = y;
        y.right = t3;
        return x;
    }

    public int isBalanced(TreeNode root) {
        if ( root == null ) {
            return 0;
        }
        return getHeight(root.left) - getHeight(root.right);
    }

    public int getHeight(TreeNode root) {
        if ( root == null ) {
            return 0;
        }
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        return Math.max(leftH, rightH) + 1;
    }


    public static void main(String[] args) {
        AVLTree avlTree = new AVLTree();
        TreeNode root = new TreeNode(1);
        avlTree.insertNode(root, 2);
        root = avlTree.insertNode(root, 3);
        System.out.println(root);
    }
}
