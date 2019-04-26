package lintcode._245;

public class Solution {

    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here

        if (T1 == null) {
            return false;
        }

        if (helper(T1, T2))
            return true;

        return isSubtree(T1.left, T2) || isSubtree(T1.right, T2);

    }

    public boolean helper(TreeNode t1, TreeNode t2){

        if (t1 == null && t2 == null)
            return true;
        if (t1 == null || t2 == null)
            return false;
        if (t1.val != t2.val){
            return false;
        }

        return helper(t1.left, t2.left) && helper(t1.right, t2.right);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode T1 = new TreeNode(1);
        T1.left = new TreeNode(2);
        T1.right = new TreeNode(3);
        T1.right.left = new TreeNode(4);

        TreeNode T2 = new TreeNode(3);
        T2.left = new TreeNode(5);

        boolean result = sol.isSubtree(T1, T2);
        System.out.println(result);
    }

}
