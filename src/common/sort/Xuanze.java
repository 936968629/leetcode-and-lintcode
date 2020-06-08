package common.sort;

import java.util.Arrays;

public class Xuanze {

    public static void main(String[] args) {
        int[] arr = {1, 9, 90, 2,67,39,10,327,8};

        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if ( arr[j] < arr[min] ) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }
}
