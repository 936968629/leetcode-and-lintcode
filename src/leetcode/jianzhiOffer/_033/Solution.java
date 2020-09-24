package leetcode.jianzhiOffer._033;

public class Solution {

    public boolean verifyPostorder(int[] postorder) {
        int length = postorder.length;
        if (length == 0) {
            return true;
        }
        return helper(postorder, 0, length - 1);
    }

    public boolean helper(int[] postorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = postorder[end];
        int i = start;
        while (postorder[i] < root) {
            i++;
        }
        int j = i;
        while (postorder[j] > root) {
            j++;
        }
        return j == end && helper(postorder, start, i-1) && helper(postorder,i, end-1);
    }

}
