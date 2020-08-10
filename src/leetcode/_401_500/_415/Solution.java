package leetcode._401_500._415;

public class Solution {

    public String addStrings(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0) {
            return num1.length() == 0 ? num2 : num1;
        }
        StringBuilder result = new StringBuilder();
        StringBuilder s1 = new StringBuilder(num1);
        StringBuilder s2 = new StringBuilder(num2);
        s1 = s1.reverse();
        s2 = s2.reverse();

        int i = 0;
        int sinal = 0;
        while (i < s1.length() && i < s2.length()) {
            int total = Integer.parseInt(String.valueOf(s1.charAt(i))) + Integer.parseInt(String.valueOf(s2.charAt(i))) + sinal;
            if (total >= 10) {
                total = total % 10;
                sinal = 1;
            }else {
                sinal = 0;
            }
            result.append(total);
            i++;
        }

        while (i < s1.length()) {
            int total = Integer.parseInt(String.valueOf(s1.charAt(i))) + sinal;
            if (total >= 10) {
                total = total % 10;
                sinal = 1;
            }else {
                sinal = 0;
            }
            result.append(total);
            i++;
        }

        while (i < s2.length()) {
            int total = Integer.parseInt(String.valueOf(s2.charAt(i))) + sinal;
            if (total >= 10) {
                total = total % 10;
                sinal = 1;
            }else {
                sinal = 0;
            }
            result.append(total);
            i++;
        }
        if (sinal == 1) {
            result.append(1);
        }

        return result.reverse().toString();
    }



}
