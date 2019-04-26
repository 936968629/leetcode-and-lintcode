package lintcode._046;

import java.util.List;

public class Solution {

    public int majorityNumber(List<Integer> nums) {
        // write your code here
        int mark = -1;
        int count= 0;
        if (nums.isEmpty()){
            return -1;
        }
        for(int i=0;i<nums.size();i++){
            if (count == 0){
                mark = nums.get(i);
                count++;
            }else{
                if (mark != nums.get(i)){
                    count --;
                }else{
                    count++;
                }
            }
        }

        return mark;
    }


}
