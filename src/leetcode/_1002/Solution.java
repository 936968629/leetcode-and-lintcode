package leetcode._1002;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> commonChars(String[] A) {
        int length = A.length;
        if (length == 0) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();

        String first = A[0];
        int[] charTable = new int[26];
        for (int i = 0; i < first.toCharArray().length; i++) {
            charTable[first.charAt(i) - 'a']++;
        }

        for (int i = 1; i < length; i++) {
            int[] temp = new int[26];
            for (int j = 0; j < A[i].toCharArray().length; j++) {
                temp[A[i].charAt(j) - 'a']++;
            }

            for (int j = 0; j < 26; j++) {
                charTable[j] = Math.min(charTable[j], temp[j]);
            }
        }

        for (int i = 0; i < 26; i++) {
            if (charTable[i] != 0) {
                for (int j = 0; j < charTable[i]; j++) {
                    result.add((char)(i+'a') + "");
                }
            }
        }

        return result;
    }

}
