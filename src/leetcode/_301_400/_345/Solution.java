package leetcode._301_400._345;

import javax.swing.border.CompoundBorder;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    public String reverseVowels(String s) {
        int length = s.length();
        if (length == 0) {
            return s;
        }
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');
        char[] chars = s.toCharArray();
        int i = 0;
        int j = length - 1;

        while (i <= j) {
            while (i <= j && !set.contains(chars[i])) {
                i++;
            }
            while (i <= j && !set.contains(chars[j])) {
                j--;
            }

            if (i <= j) {
                swap(chars, i, j);
                i++;
                j--;
            }
        }

        return String.valueOf(chars);
    }

    public void swap(char[] chars, int i,int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
