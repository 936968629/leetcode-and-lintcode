package lintcode._001_100._046;

import java.util.List;

public class Solution {

    public int majorityNumber(List<Integer> nums) {
        // write your code here
        int major = -1;
        int count = 0;
        for (Integer item : nums) {
            if ( count == 0 ) {
                major = item;
                count++;
            }else if ( item == major ) {
                count++;
            }else{
                count--;
            }
        }
        return major;
    }


}
