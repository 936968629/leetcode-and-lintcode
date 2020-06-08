package common.sort;

import java.util.Arrays;

public class Guibing {

    public static void main(String[] args) {
        int[] arr = {1, 9, 90, 2,67,39,10,327,8};


        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right) {

        if ( left < right ) {
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[arr.length];
        int i = left;
        int j = mid + 1;
        int k = left;
        while ( i <= mid && j <= right) {
            if ( arr[i] < arr[j] ) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while ( j <= right) {
            temp[k++] = arr[j++];
        }

        for (int l = left; l <= right ; l++) {
            arr[l] = temp[l];
        }

    }
}
