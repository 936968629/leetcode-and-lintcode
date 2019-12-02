package lintcode._136;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        // write your code here
        if (s.length() == 0){
            return res;
        }
        dfs(s, 0, s.length(), new ArrayList<>());
        return res;
    }

    public void dfs(String s, int index, int end, List<String> cur){

        if (s.length() == index){
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isReverse(s, index, i)){
                cur.add(s.substring(index, i+1));
                dfs(s, i+1, end, cur);
                cur.remove(cur.size()-1);
            }
        }

    }

    public boolean isReverse(String s, int start, int end){

        while (start < end){
            if (s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }

        return true;
    }

}
