package lintcode._655;

public class Solution {

    public String addStrings(String num1, String num2) {
        // write your code here
        StringBuilder stringBuilder = new StringBuilder(num1);
        char[] reverse1 = stringBuilder.reverse().toString().toCharArray();
        StringBuilder stringBuilder2 = new StringBuilder(num2);
        char[] reverse2 = stringBuilder2.reverse().toString().toCharArray();
        int i = 0;
        int j = 0;
        int item1 = 0;
        int item2 = 0;
        int jinwei = 0;
        StringBuilder result = new StringBuilder();
        while ( i < reverse1.length || j < reverse2.length ) {
            if ( i >= reverse1.length ) {
                item2 = Integer.valueOf(String.valueOf(reverse2[j]));
                item1 = 0;
                j++;
            }else if ( i >= reverse2.length ) {
                item1 = Integer.valueOf(String.valueOf(reverse1[i]));
                item2 = 0;
                i++;
            }else{
                item1 = Integer.valueOf(String.valueOf(reverse1[i]));
                item2 = Integer.valueOf(String.valueOf(reverse2[j]));
                i++;
                j++;
            }
            int sum = item1 + item2 + jinwei;
            if ( sum >= 10 ) {
                sum -= 10;
                jinwei = 1;
            } else {
                jinwei = 0;
            }
            result.append(sum);
        }
        if (jinwei == 1) {
            result.append(1);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.addStrings("935", "65"));
    }

}
