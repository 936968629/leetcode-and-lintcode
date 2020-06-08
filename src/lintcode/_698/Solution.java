package lintcode._698;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {

    public int maxDiff(int[][] arrs) {
        // write your code here
        int rows = arrs.length;
        if (rows == 0){
            return 0;
        }
        List<Command> maxList = new ArrayList<>();
        List<Command> minList = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            int[] item = arrs[i];
            int size = item.length;
            minList.add(new Command(item[0],i));
            maxList.add(new Command(item[size-1],i));
        }

        Collections.sort(maxList, new Comparator<Command>() {
            @Override
            public int compare(Command o1, Command o2) {
                return o2.val - o1.val;
            }
        });

        Collections.sort(minList, new Comparator<Command>() {
            @Override
            public int compare(Command o1, Command o2) {
                return o1.val - o2.val;
            }
        });

        if (minList.get(0).index != maxList.get(0).index){
            return maxList.get(0).val - minList.get(0).val;
        }else{
            return Math.max(maxList.get(0).val - minList.get(1).val, maxList.get(1).val - minList.get(0).val);
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {{2,3,4,5,6,7,8,9},{1,10},{-1,200}};
        int res = solution.maxDiff(arr);
        System.out.println(res);
    }

}
class Command{

    public int val;

    public int index;

    public Command(int val, int index){
        this.index = index;
        this.val = val;
    }
}