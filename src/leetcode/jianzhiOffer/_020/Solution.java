package leetcode.jianzhiOffer._020;

public class Solution {

    public boolean isNumber(String s) {
        s = s.trim();
        int p=0,n=0,e=0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '.':
                    if(i>0&&!Character.isDigit(s.charAt(i-1))&&s.charAt(i-1)!='+'&&s.charAt(i-1)!='-'||i<s.length()-1&&!Character.isDigit(s.charAt(i+1))&&s.charAt(i+1)!='+'&&s.charAt(i+1)!='-'&&s.charAt(i+1)!='e'&&s.charAt(i+1)!='E'||p==1||s.length()==1||e==1)
                        return false;
                    p++;
                    break;
                case '+':
                case '-':if(i!=0&&(s.charAt(i-1)!='e'&&s.charAt(i-1)!='E')||i==s.length()-1)
                    return false;
                break;
                case 'e':
                case 'E':if(i==0||i==s.length()-1||n==0||e>0) return false; p=0; e++;break;
                case ' ':  return false;

                default:if(!Character.isDigit(s.charAt(i))) return false;
                n++;
            }
        }
        return n > 0;
    }

}
