package leetcode._744;

public class Solution {

    public char nextGreatestLetter(char[] letters, char target) {
        int length = letters.length;
        if (length == 0) {
            return 0;
        }
        int left = 0;
        int right = length - 1;
        while (left + 1 < right) {
            int mid = left + (right-left) / 2;
            if (letters[mid] == target) {
                left = mid;
            }else if (letters[mid] < target) {
                left = mid;
            }else {
                right = mid;
            }
        }
        if (letters[left] > target) {
            return letters[left];
        }
        if (letters[right] > target) {
            return letters[right];
        }else {
            return letters[0];
        }
    }

}
