package leetcode._101_200._119;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < rowIndex+1; i++) {
            List<Integer> item = new ArrayList<>();
            if (i < 2) {
                for (int j = 0; j < i+1; j++) {
                    item.add(1);
                }
            }else {
                List<Integer> prev = result.get(i-1);
                for (int j = 0; j < i+1; j++) {
                    if (j == 0 || j == i) {
                        item.add(1);
                    }else {
                        item.add(prev.get(j-1) + prev.get(j));
                    }
                }
            }
            result.add(item);
        }
        return result.get(result.size()-1);
    }

}
