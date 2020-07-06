package lintcode._401_500._413;

public class Solution {

    public int reverseInteger(int n) {
        // write your code here
        if ( n < 0 ) {
            n = Math.abs(n);
            char[] chars = String.valueOf(n).toCharArray();
            reverse(chars);
            try {
                Integer integer = Integer.valueOf("-"+String.valueOf(chars));
                return integer;
            } catch (Exception e) {
                return 0;
            }
        }else if ( n > 0 ) {
            char[] chars = String.valueOf(n).toCharArray();
            reverse(chars);
            try {
                Integer integer = Integer.valueOf(String.valueOf(chars));
                return integer;
            } catch (Exception e) {
                return 0;
            }
        }else {
            return 0;
        }
    }

    public void reverse(char[] chars) {
        int i = 0;
        int j = chars.length - 1;
        while ( i < j ) {
            swap(chars, i, j);
            i++;
            j--;
        }

    }

    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

}
