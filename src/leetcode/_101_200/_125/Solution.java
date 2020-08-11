package leetcode._101_200._125;

public class Solution {

    public boolean isPalindrome(String s) {
        int length = s.length();
        int i = 0;
        int j = length-1;
        while (i <= j) {
            while (!Character.isLetterOrDigit(s.charAt(i)) && i < j) {
                i++;
            }
            while (!Character.isLetterOrDigit(s.charAt(j)) && i < j) {
                j--;
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
