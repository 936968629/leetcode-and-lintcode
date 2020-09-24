package leetcode._001_100._067;

public class Solution {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int lenA = a.length();
        int lenB = b.length();
        int i = 0;
        int j = 0;
        int signal = 0;
        a = reverse(a);
        b = reverse(b);
        while (i < lenA && j < lenB) {
            int total = Integer.valueOf(String.valueOf(a.charAt(i))) + Integer.valueOf(String.valueOf(b.charAt(j))) + signal;
            if (total >= 2) {
                total = total % 2;
                signal = 1;
            }else {
                signal = 0;
            }
            sb.append(total);
            i++;
            j++;
        }
        while (i < lenA) {
            int total = Integer.valueOf(String.valueOf(a.charAt(i))) + signal;
            if (total >= 2) {
                total = total % 2;
                signal = 1;
            }else {
                signal = 0;
            }
            sb.append(total);
            i++;
        }

        while (j < lenB) {
            int total = Integer.valueOf(String.valueOf(b.charAt(j))) + signal;
            if (total >= 2) {
                total = total % 2;
                signal = 1;
            }else {
                signal = 0;
            }
            sb.append(total);
            j++;
        }
        if (signal == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public String reverse(String a) {
        return new StringBuilder(a).reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();


        solution.addBinary("1010", "1011");
    }

}
