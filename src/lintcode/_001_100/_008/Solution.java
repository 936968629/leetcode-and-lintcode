package lintcode._001_100._008;

import java.util.Arrays;

public class Solution {


    public void rotateString(char[] str, int offset) {
        // write your code here
        if(str.length == 0 || offset == 0){
            return;
        }
        int lenth = str.length;
        if (offset > lenth){
            offset = offset % lenth;
        }
        reverse(str,0,lenth-1);

        reverse(str, 0, offset-1);
        reverse(str, offset,lenth-1);

    }

    public void reverse(char[] str, int start, int end){
        int i = start;
        int j = end;
        while (i < j){
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        char[] str = {'a','b','c','d','e','f','g'};
        char[] str = {'a','b','c','c','b','a'};
        sol.rotateString(str, 3);
        System.out.println(Arrays.toString(str));
    }
}
