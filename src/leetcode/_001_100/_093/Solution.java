package leetcode._001_100._093;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> result = new ArrayList<>();
        // 如果长度不够，不搜索
        if (len < 4 || len > 12) {
            return result;
        }
        dfs(result, s, new StringBuilder(), 0, 0);
        return result;
    }

    public void dfs(List<String> result, String s, StringBuilder path, int start, int dot) {
        if (start == s.length() && dot == 4) {
            path.deleteCharAt(path.length() - 1);
            result.add(path.toString());
            return;
        }
        if (dot > 4) {
            return;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String temp = s.substring(start, i);
            if (temp.length() >= 2 && temp.charAt(0) == '0') {
                //首位不为0
                break;
            }
            int cur = Integer.parseInt(temp);//数值不超255
            if (cur > 255) {
                break;
            }
            path.append(temp);//满足条件添加到path中
            path.append(".");
            dfs(result, s, path, i, dot + 1);
            path.delete(start + dot, i + 1 + dot);
        }
    }


}
