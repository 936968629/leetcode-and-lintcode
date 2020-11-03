package leetcode._401_500._468;

public class Solution {

    public String validIPAddress(String IP) {
        //172.16.254.1
        if (IP.contains(".")) {
            //v4
            if (IP.endsWith(".")) {
                return "Neither";
            }
            String[] strs = IP.split("\\.");
            if(strs.length!=4){
                return "Neither";
            }
            for (String str : strs) {
                if (str.length() < 1 || str.length() > 3) {
                    return "Neither";
                }
                if (str.startsWith("0") && str.length() > 1) {
                    return "Neither";
                }
                if (!validNum(str)) {
                    return "Neither";
                }
            }
            return "IPv4";
        }else if (IP.contains(":")) {
            // v6 2001:0db8:85a3:0000:0000:8a2e:0370:7334
            if (IP.endsWith(":")) {
                return "Neither";
            }
            String[] strs = IP.split(":");
            if(strs.length!=8){
                return "Neither";
            }

            for (String str : strs) {
                if (str.length() < 1 || str.length() > 4) {
                    return "Neither";
                }
                if(!validHex(str)){
                    return "Neither";
                }
            }
            return "IPv6";
        }else {
            return "Neither";
        }

    }

    private boolean validHex(String s){
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(!(ch>='0'&&ch<='9' || ch>='a'&&ch<='f' || ch>='A'&&ch<='F')){
                return false;
            }
        }
        return true;
    }


    private boolean validNum(String s){
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if (item < '0' || item > '9') {
                return false;
            }
            res = res * 10 + item - '0';
        }
        return res >= 0 && res <= 255;
    }

}
