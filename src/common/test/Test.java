package common.test;

import com.sun.imageio.plugins.common.I18N;
import common.sort.Fast;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Test {

    public int romanToInt(String s) {
        // write your code here
        if (s.length() == 0){
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int length = s.length();
        int res = map.get(s.charAt(length-1));
        for (int i = length - 2; i >= 0 ; i--) {
            if (map.get(s.charAt(i+1)) <= map.get(s.charAt(i)) ){
                res += map.get(s.charAt(i));
            }else{
                res -= map.get(s.charAt(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {

        Test test = new Test();

    }

}
