package lintcode._1350;

public class Solution {

    public String convertToTitle(int n) {
        // write your code here

        StringBuilder result = new StringBuilder();
        while ( n > 0 ) {
            n--;
            result.append( (char)n % 26 + 'A');
            n = n / 26;
        }
        return result.reverse().toString();
    }

}
