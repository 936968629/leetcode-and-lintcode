package common.test;

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

    public int findMin(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return -1;
        }
        int left = 0;
        int right = length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            }else if (nums[mid] > nums[right]){
                left = mid;
            }else {
                right--;
            }
        }
        return nums[left] > nums[right] ? nums[right]:nums[left];
    }

    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("common.test.Solution");
            Solution fast = (Solution) aClass.newInstance();
            int[] nums ={12,2,3};
            Method method = aClass.getDeclaredMethod("findMin", int[].class);
            Object invoke = method.invoke(fast, nums);
            System.out.println(invoke.toString());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
