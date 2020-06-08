package lintcode._101_200._157;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public boolean isUnique(String str){

        Set<Character> set = new HashSet<>();
        char[] chars = str.toCharArray();
        for (char i : chars){
            set.add(i);
        }
        return set.size() == str.length();


    }

}
