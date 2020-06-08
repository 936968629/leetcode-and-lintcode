package common.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {1,4,9,10,33,2,34,56,11,99,0,4};

//        int[] arr = {4,6};

        sort(arr, 0, arr.length-1);

        System.out.println(Arrays.toString(arr));
    }


    public static void sort(int[] arr, int left, int right){
        if ( left < right) {
            int mid = partition(arr, left, right);
            sort(arr, left, mid-1);
            sort(arr, mid+1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int flag = arr[right];
        int i = left;
        int j = right -1;
        while ( i <= j ) {

            while (i <= j && arr[i] <= flag ){
                i++;
            }
            while ( i <= j && arr[j] > flag ) {
                j--;
            }
            if ( i < j ) {
                swap(arr, i, j);
            }
        }
        swap(arr, i, right);
        return i;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
