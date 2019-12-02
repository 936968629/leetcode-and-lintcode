package common.sort;

import java.util.Arrays;

public class Maopao {

    public static void main(String[] args) {
        int[] arr = {1, 9, 90, 2,67,39,10,327,8};

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if ( arr[j] > arr[j+1] ) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }


            }
        }
        System.out.println(Arrays.toString(arr));
        
        
    }
}
