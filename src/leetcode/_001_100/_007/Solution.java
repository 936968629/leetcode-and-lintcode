package leetcode._001_100._007;

public class Solution {

    public int reverse(int x) {
        double a;
        if (x == 0) {
            return 0;
        }else if (x > 0) {
            String s = String.valueOf(x);
            StringBuilder sb = new StringBuilder(s);
            a  = Double.valueOf(sb.reverse().toString());
        }else {
            String s = String.valueOf(x);
            StringBuilder sb = new StringBuilder(s);
            String q = sb.reverse() + "";
            String c = q.replace("-", "");
            a = Double.parseDouble("-" + c);
        }
        return (int) a == a ? (int) a : 0;
    }

}
