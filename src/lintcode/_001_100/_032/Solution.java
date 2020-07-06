package lintcode._001_100._032;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Solution {

    int[] letters = new int[256];

    public String minWindow(String source , String target) {
        // write your code here
        for (int i = 0; i < target.length(); i++) {
            letters[target.charAt(i)]++;
        }

        int i = 0, j = 0, length = Integer.MAX_VALUE;
        String result = "";

        for (i = 0; i < source.length(); i++) {
            while (j < source.length() && !isAllFound()) {
                letters[source.charAt(j)]--;
                j++;
            }

            if (isAllFound() && j - i < length) {
                length = j - i;
                result = source.substring(i, j);
            }

            letters[source.charAt(i)]++;
        }

        return result;

    }

    private boolean isAllFound() {
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Solution solution = new Solution();
        solution.minWindow("adobecodebanc","abc");

        ArrayList<Integer> arrayList3=new ArrayList<Integer>();

        //这样调用add方法只能存储整形，因为泛型类型的实例为Integer
        arrayList3.add(1);
        arrayList3.getClass().getMethod("add", Object.class).invoke(arrayList3, "asd");

        for (int i=0;i<arrayList3.size();i++) {

            System.out.println(arrayList3.get(i));

        }
    }
}
