package lintcode._001_100._047;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public int majorityNumber(List<Integer> nums){

        int major1 = -1;
        int major2 = -1;
        int count1 = 0;
        int count2 = 0;
        for (Integer item : nums) {
            if ( count1 == 0 ) {
                major1 = item;
                count1++;
            }else if ( item == major1 ) {
                count1++;
            }else if ( count2 == 0 ){
                major2 = item;
                count2++;
            }else if ( item == major2 ) {
                count2++;
            }else {
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        for(Integer item : nums) {
            if ( item == major1 ) {
                count1++;
            }else if ( item == major2 ) {
                count2++;
            }
        }
        return count1 > nums.size()/3 ? major1:major2;
    }

}
