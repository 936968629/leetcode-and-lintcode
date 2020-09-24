package leetcode._401_500._433;

import java.util.*;

public class Solution {

    public int minMutation(String start, String end, String[] bank) {
        
        Set<String> set = new HashSet<>();
        for (int i = 0; i < bank.length; i++) {
            set.add(bank[i]);
        }
        if (!set.contains(end)) {
            return 0;
        }
        if (start.equals(end)) {
            return 0;
        }
        List<Character> coins = Arrays.asList('A', 'C', 'G', 'T');
        Set<String> visited = new HashSet<>();
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);

        int res = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                //"A", "C", "G", "T"
                char[] chars = poll.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char temp = chars[j];
                    for (int k = 0; k < coins.size(); k++) {
                        Character newChar = coins.get(k);
                        if (newChar != temp) {
                            chars[j] = newChar;
                            String newStr = String.valueOf(chars);
                            if (end.equals(newStr)) {
                                return res;
                            }
                            if (set.contains(String.valueOf(chars)) && !visited.contains(String.valueOf(chars))) {
                                visited.add(String.valueOf(chars));
                                queue.offer(String.valueOf(chars));
                            }
                        }
                    }
                    chars[j] = temp;
                }
            }
            res++;
        }

        return -1;
    }

    public static void main(String[] args) {
        String start = "AACCTTGG";
        String end = "AATTCCGG";
        String[] bank = {"AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"};

        Solution solution = new Solution();
        solution.minMutation(start, end, bank);
    }

}
