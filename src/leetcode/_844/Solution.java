package leetcode._844;

import java.util.Stack;

public class Solution {

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '#') {
                if (!stackS.isEmpty()) {
                    stackS.pop();
                }
            }else {
                stackS.push(S.charAt(i));
            }
        }

        Stack<Character> stackT = new Stack<>();
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) == '#') {
                if (!stackT.isEmpty()) {
                    stackT.pop();
                }
            }else {
                stackT.push(T.charAt(i));
            }
        }

        if (stackS.size() != stackT.size()) {
            return false;
        }
        for (int i = 0; i < stackS.size(); i++) {
            if (stackS.get(i) != stackT.get(i)) {
                return false;
            }
        }
        return true;
    }

}
