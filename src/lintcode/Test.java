package lintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {

    public boolean canJump(int[] A) {
        // write your code here
        int length = A.length;
        if ( length == 0 ) {
            return true;
        }
        //dp[i]表示能否跳到i这个点
        boolean[] dp = new boolean[length];
        dp[0] = true;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && j + A[j] >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length-1];
    }

    public static void main(String[] args) {
        Test test = new Test();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(3);
        int[] A = {3,2,1,0,4};
        test.canJump(A);
    }

}
