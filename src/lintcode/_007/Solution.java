package lintcode._007;

import lintcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public String serialize(TreeNode root) {
        // write your code here
        List<String> strList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode item = queue.poll();
            if (item != null){
                strList.add(String.valueOf(item.val));
                queue.offer(item.left);
                queue.offer(item.right);
            }else{
                strList.add("#");
            }

        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < strList.size(); i++) {
            str.append(strList.get(i));
            if (i < strList.size() - 1){
                str.append(",");
            }
        }
        return str.toString();
    }

    public TreeNode deserialize(String data) {
        // write your code here
        String[] strs = data.split(",");
        if (strs.length == 0||data.equals("#")) {
            TreeNode rooTreeNode = null;
            return rooTreeNode;
        } else {
            Queue<TreeNode> dataqueue = new LinkedList<>();
            TreeNode rootNode = new TreeNode(Integer.parseInt(strs[0]));
            dataqueue.add(rootNode);
            int i = 1;
            while (!dataqueue.isEmpty() && i < strs.length) {//直到队列为空，或者数组中元素被取完了
                TreeNode treeNode = dataqueue.poll();//每次弹出队列的第一个节点，分别构造左右节点
                if (strs[i].equals("#")) {
                    treeNode.left = null;
                    i++;
                } else {//如果不是空节点，那么我们要把这个节点加入队列中，这意味着这个节点可能还有子节点
                    treeNode.left = new TreeNode(Integer.parseInt(strs[i]));
                    dataqueue.offer(treeNode.left);
                    i++;
                }
                //下面接着判断右节点，注意，有可能数组被取光了，也就是没有右节点了
                if (i < strs.length&&strs[i].equals("#") ) {
                    treeNode.right = null;
                    i++;
                } else if(i < strs.length&& !strs[i].equals("#")){
                    treeNode.right = new TreeNode(Integer.parseInt(strs[i]));
                    dataqueue.add(treeNode.right);
                    i++;
                }

            }
            return rootNode;
        }

    }

    public static void main(String[] args) {

    }
}
