package lintcode._001_100._055;

public class Solution {

    public boolean compareStrings(String A, String B) {
        // write your code here
        int[] letters = new int[256];
        for (int i = 0; i < B.length(); i++) {
            letters[B.charAt(i)]++;
        }
        for (int i = 0; i < A.length(); i++) {
            letters[A.charAt(i)]--;
        }

        for (int i = 0; i < 256; i++) {
            if ( letters[i] > 0 ) {
                return false;
            }
        }
        return true;
    }

}
