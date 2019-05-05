package lintcode._137;

import org.omg.CORBA.UNKNOWN;

import java.util.*;

public class Solution {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null){
            return node;
        }

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        map.put(node, new UndirectedGraphNode(node.label));
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()){
            UndirectedGraphNode item = queue.poll();
            for (UndirectedGraphNode i : item.neighbors){
                if ( !map.containsKey(i) ){
                    map.put(i, new UndirectedGraphNode(i.label));
                    queue.offer(i);
                }
            }
        }
//        System.out.println(map);
        for (Map.Entry<UndirectedGraphNode, UndirectedGraphNode> entry:map.entrySet()){
            UndirectedGraphNode key = entry.getKey();
            for (UndirectedGraphNode n : key.neighbors){
                entry.getValue().neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }

}
