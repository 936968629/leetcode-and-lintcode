package lintcode._204;

public class Solution {

    private static Solution instance = null;

    public static synchronized Solution getInstance() {
        if (instance == null) {
            instance = new Solution();
        }
        return instance;
    }

    public static void main(String arg[]) {
        Solution sol = Solution.getInstance();
    }
}
