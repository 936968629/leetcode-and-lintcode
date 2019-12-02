package lintcode._689;

import lintcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[] twoSum(TreeNode root, int n) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int[] res = new int[2];
        for (int i = 0, j = list.size()-1; i < j;) {
            if (list.get(i)+list.get(j) == n){
                return new int[]{list.get(i), list.get(j)};
            }else if (list.get(i)+list.get(j) > n){
                j--;
            }else{
                i++;
            }
        }
        return res;
    }

    public void inorder(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

}
