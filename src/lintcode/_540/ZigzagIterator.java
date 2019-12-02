package lintcode._540;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigzagIterator {

    List<Integer> list = new ArrayList<>();
    Stack<Integer> stack = new Stack<>();
    int index= 0;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        // do intialization if necessary
        int i=0, j=0;
        while (i<v1.size() || j<v2.size()){
            if (i<v1.size() && j<v2.size()){
                list.add(v1.get(i));
                list.add(v2.get(j));
                i++;
                j++;
            }
            else if (i<v1.size()){
                list.add(v1.get(i));
                i++;
            }
            else{
                list.add(v2.get(j));
                j++;
            }
        }
    }


    // write your code here
    public int next() {
        Integer res = list.get(index);
        index++;
        return res;
    }


    public boolean hasNext() {
        // write your code here
        return index < list.size();
    }
}
