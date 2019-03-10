package lintcode._212;

public class Solution {

    public int replaceBlank(char[] string, int length) {
        // write your code here
        int blank_count = 0;
        for(char _i : string) {
            if(_i == ' ')
                blank_count += 1;
        }

        int new_length = 2 * blank_count + length;
        int j = new_length - 1;
        for(int i = length-1; i>=0;i--) {
            if(string[i] == ' '){
                string[j] = '0';
                string[j-1] = '2';
                string[j-2] = '%';
                j -= 3;
            } else {
                string[j] = string[i];
                j-=1;
            }

        }
        System.out.println(String.valueOf(string));
        return new_length;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        char[] strs = {'M','r',' ','J','o','h','n',' ','S','m','i','t','h'};
        int length = strs.length;
        sol.replaceBlank(strs, length);
    }
}
