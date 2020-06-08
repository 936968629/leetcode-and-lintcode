package lintcode._001_100._013;

public class Solution {

    public int strStr(String source, String target) {
        // Write your code here

        int sLength = source.length();
        int jLength = target.length();

        if (jLength == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < sLength - jLength + 1; i++) {
            for (j = 0; j < jLength; j++) {
                if (source.charAt(i+j) != target.charAt(j)) {
                    break;
                }
            }

            if (j == jLength){
                return i;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String source = "mississippi";
        String target = "issipp";
        int res = sol.strStr(source, target);
        System.out.println(res);
    }

}
