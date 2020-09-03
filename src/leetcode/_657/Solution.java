package leetcode._657;

public class Solution {

    public boolean judgeCircle(String moves) {
        //R（右），L（左），U（上）和 D（下）
        int r = 0 ;
        int c = 0;
        for (int i = 0; i < moves.length(); i++) {
            char ch = moves.charAt(i);
            if (ch == 'R') {
                c++;
            }else if (ch == 'L') {
                c--;
            }else if (ch == 'U') {
                r--;
            }else {
                r++;
            }
        }
        return r==0 && c== 0;
    }

}
