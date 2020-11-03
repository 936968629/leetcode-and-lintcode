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

    public int reverse2(int x) {
        int res = 0;
        while (x != 0) {
            int tmp = x % 10;
            int newRes = res * 10 + tmp;
            //判断溢出
            if (res != (newRes - tmp) / 10) {
                return 0;
            }
            res = newRes;
            x = x / 10;
        }
        return res;
    }

}
