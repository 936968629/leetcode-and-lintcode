package leetcode._301_400._344;

public class Solution {

    public void reverseString(char[] s) {
        int length = s.length;
        if (length <= 1) {
            return;
        }
        int i = 0;
        int j = length-1;
        while (i <= j) {
            swap(s, i, j);
            i++;
            j--;
        }
    }

    public void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

}
