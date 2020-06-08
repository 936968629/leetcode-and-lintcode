package lintcode._101_200._186;

import java.util.HashMap;
import java.util.Map;

public class Solution {


    public int maxPoints(Point[] points) {
        // write your code here
        int length = points.length;
        if (length <= 2){
            return length;
        }
        Map<Double, Integer> map = new HashMap<>();
        int max = 2;
        for (int i = 0; i < length; i++) {
            map.clear();

            // maybe all points contained in the list are same points,and same points' k is
            // represented by Integer.MIN_VALUE
            map.put((double)Integer.MIN_VALUE, 1);
            int dup = 0;
            for (int j = i+1; j < length; j++) {
                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    dup++;
                    continue;
                }

                double key=points[j].x - points[i].x == 0 ? Integer.MAX_VALUE :
                        0.0 + (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                if (map.containsKey(key)) {
                    map.put(key, map.get(key) + 1);
                } else {
                    map.put(key, 2);
                }

            }
            for (int temp: map.values()) {
                // duplicate may exist
                if (temp + dup > max) {
                    max = temp + dup;
                }
            }
        }
        return max;
    }

}
