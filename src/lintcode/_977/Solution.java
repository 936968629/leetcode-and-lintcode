package lintcode._977;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public String convertToBase7(int num) {

        if ( num < 0 ) {
            return "-" + convertToBase7(-num);
        }

        if ( num < 7 ) {
            return String.valueOf(num);
        }

        return convertToBase7(num / 7) + num % 7;
    }

    public List<String> list = Arrays.asList("0","1","2","3","4","5","6","7","8","9","a","b","c","d","e",
            "f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z");

    public String convertToBase36(int num) {

        if ( num < 36 ) {
            return list.get(num);
        }

        return convertToBase36(num / 36) + list.get(num % 36);
    }

    //36进制加法
    public String jiafa(String s, String t) {
        StringBuilder result = new StringBuilder();
        int i = s.length() - 1;
        int j = t.length() - 1;
        int temp = 0;
        while ( i>=0 && j>= 0 ) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(j);
            int sIndex = list.indexOf(String.valueOf(sChar));
            int tIndex = list.indexOf(String.valueOf(tChar));
            int num = sIndex + tIndex + temp;
            if ( num > 36 ) {
                temp = 1;
                result.append(list.get(num % 36));
            } else {
                temp = 0;
                result.append(list.get(num % 36));
            }
            i--;
            j--;
        }

        while ( i>=0 ) {
            char sChar = s.charAt(i);
            int sIndex = list.indexOf(String.valueOf(sChar));
            int num = sIndex + temp;
            if ( num > 36 ) {
                temp = 1;
                result.append(list.get(num % 36));
            } else {
                temp = 0;
                result.append(list.get(num % 36));
            }
            i--;
        }

        while ( j>= 0 ) {
            char tChar = t.charAt(j);
            int tIndex = list.indexOf(String.valueOf(tChar));
            int num = tIndex + temp;
            if ( num > 36 ) {
                temp = 1;
                result.append(list.get(num % 36));
            } else {
                temp = 0;
                result.append(list.get(num % 36));
            }
            j--;
        }

        if ( temp > 0 ) {
            result.append("1");
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.convertToBase36(26);
        System.out.println(s);
    }
}
