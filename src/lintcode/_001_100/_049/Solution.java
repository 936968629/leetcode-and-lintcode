package lintcode._001_100._049;

public class Solution {

    public void sortLetters(char[] chars) {
        // write your code here
        int length = chars.length;
        if ( length == 0 ) {
            return;
        }
        int i = 0;
        int j = length - 1;
        while ( i < j ) {
            while ( i < j && chars[i] - 'a' >= 0 ) {
                i++;
            }
            while ( i < j && chars[j] - 'a' < 0) {
                j--;
            }
            if ( i < j ) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
            }
        }

    }

    public static void main(String[] args) {

    }

}
