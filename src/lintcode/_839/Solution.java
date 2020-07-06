package lintcode._839;

import lintcode._001_100._030.Interval;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        // write your code here
        if (list1 == null || list1.size() == 0) {
            return list2;
        }
        if (list2 == null || list2.size() == 0) {
            return list1;
        }
        List<Interval> result = new ArrayList<>();
        int i = 0 ;
        int j = 0;
        while ( i < list1.size() && j < list2.size() ) {
            if ( list1.get(i).start <= list2.get(j).start ) {
                merge(result, list1.get(i));
                i++;
            } else {
                merge(result, list2.get(j));
                j++;
            }
        }
        while ( i < list1.size() ) {
            merge(result, list1.get(i));
            i++;
        }
        while ( j < list2.size() ) {
            merge(result, list2.get(j));
            j++;
        }
        return result;
    }

    public void merge(List<Interval> list, Interval interval) {

        if (list.size() == 0) {
            list.add(interval);
            return;
        }

        Interval last = list.get(list.size() - 1);

        if (last.end < interval.start) {
            list.add(interval);
            return;
        }

        if (last.end < interval.end) {
            last.end = interval.end;
            return;
        }
    }
    /**
     * 放入一个新的数组，排序合并
     */

}
