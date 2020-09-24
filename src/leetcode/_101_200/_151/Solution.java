package leetcode._101_200._151;

public class Solution {

    public String reverseWords(String s) {
        s = s.trim();
        String[] s1 = s.split("\\s+");
        int i = 0;
        int j = s1.length - 1;
        while (i <= j) {
            swap(s1, i, j);
            i++;
            j--;
        }
        return String.join(" ", s1);
    }

    public void swap(String[] s1, int i, int j) {
        String temp = s1[i];
        s1[i] = s1[j];
        s1[j] = temp;
    }

}
