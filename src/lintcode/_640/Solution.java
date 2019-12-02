package lintcode._640;

public class Solution {

    public boolean isOneEditDistance(String s, String t) {
        // write your code here
        int sLength = s.length();
        int tLength = t.length();

        if (Math.abs(sLength-tLength) > 1){
            return false;
        }

        if (sLength > tLength){
            return isOneEditDistance(t,s);
        }

        int i = 0;
        while (i < sLength){
            if (s.charAt(i) != t.charAt(i)){
                if (sLength == tLength){
                    return s.substring(i+1).equals(t.substring(i+1));
                }else{
                    return s.substring(i).equals(t.substring(i+1));
                }
            }
            i++;
        }
        return sLength+1 == tLength;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ab";
        String t = "a";
        boolean distance = solution.isOneEditDistance(s, t);
        System.out.println(distance);
    }
}
