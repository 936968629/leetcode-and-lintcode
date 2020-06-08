package lintcode._401_500._474;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    class ParentTreeNode {
        public ParentTreeNode parent, left, right;
    }

    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        // write your code here
        List<ParentTreeNode> pathA = getPath(A);
        List<ParentTreeNode> pathB = getPath(B);
        int i,j;
        for(i = pathA.size()- 1, j = pathB.size()-1; i>=0 && j>=0; i--,j--) {
            if ( pathA.get(i) != pathB.get(j) ) {
                return pathA.get(i).parent;
            }
        }

        return pathA.get(i+1);
    }

    public List<ParentTreeNode> getPath(ParentTreeNode root) {
        List<ParentTreeNode> list= new ArrayList<>();
        while ( root != null ) {
            list.add(root);
            root = root.parent;
        }
        return list;
    }
}
