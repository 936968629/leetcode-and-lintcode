package lintcode._022;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public interface NestedInteger {

              // @return true if this NestedInteger holds a single integer,
              // rather than a nested list.
              public boolean isInteger();

              // @return the single integer that this NestedInteger holds,
              // if it holds a single integer
              // Return null if this NestedInteger holds a nested list
              public Integer getInteger();

              // @return the nested list that this NestedInteger holds,
              // if it holds a nested list
              // Return null if this NestedInteger holds a single integer
              public List<NestedInteger> getList();
    }

    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        List<Integer> res = new ArrayList<>();
        for(NestedInteger item : nestedList){
            if (item.isInteger()){
                res.add(item.getInteger());
            }else{
                res.addAll(flatten(item.getList()));
            }
        }

        return res;
    }

}
