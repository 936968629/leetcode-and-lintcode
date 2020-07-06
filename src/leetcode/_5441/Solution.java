package leetcode._5441;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public String[] getFolderNames(String[] names) {
        String[] res  = new String[names.length];
        if ( names.length == 0 ) {
            return res;
        }
        Set<String> set = new HashSet<>();

        for (int i = 0; i < names.length; i++) {
            String item = names[i];
            int n = 1;
            String newItem = item;
            while ( set.contains(newItem) ) {
                if ( n == 1 ) {
                    newItem += "(1)";
                } else {
                    newItem = item + "(" + n + ")";
                }
                n++;
            }
            set.add(item);
            res[i] = item;
        }
        return res;
    }

}
