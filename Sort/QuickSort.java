package Sort;

import java.util.Scanner;

//package Sort;

/**
 * Why quick sort?
 *
 * Pros and cons
 *
 * Time complexity
 *
 * Space complexity
 */
public class QuickSort {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     *
     * @param arr .
     * @param left side array
     * @param right side array
     *
     *=============HOARE'S QUICK SORT===============
     */
    public static void HoareQuickSort(int[] arr, int left, int right) {
        // base case
        if(left >= right) return;

        // call partition to split the array to 2 parts
        int splitIndex = HoarePartition(arr, left, right); // call for the whole array

        HoareQuickSort(arr, left, splitIndex); // left side // call partition for the left side array
        HoareQuickSort(arr, splitIndex + 1, right); // right side // call partition for the right side array
    }

    public static int HoarePartition(int[] arr, int left, int right) {
        int pivotValue = arr[left + (right-left) / 2]; // choose the middle of the array to avoid N^2 time
        int i = left -  1; // start from left outside the array
        int j = right + 1; // start from right outside the array

        while (true){

            do{
                i++; // move left-pointer to the right side if arr[i] < pivot
            } while(arr[i] < pivotValue);

            do{
                j--; // move right-pointer to the left side if arr[j] > pivot
            } while(arr[j] > pivotValue);
            // for ascending
            // if want to sort in desc, replace < with >
            if(i >= j) return j; // not position of the pivot
            // just return last index of left subarray
            else {
                swap(arr, i, j);
            }
        }
    }

    /**
     *
     * @param arr .
     *============LOMUTO QUICK SORT==============
     */

    public static void LomutoQuickSort(int[] arr, int left, int right) {
        if(left >= right) return;

        int pivotIndex = LomutoPartition(arr, left, right);// with lomuto, it will return exactly position of pivot

        LomutoQuickSort(arr, left, pivotIndex - 1); // left side but not include pivot
        LomutoQuickSort(arr, pivotIndex + 1, right); // right side but not include pivot
    }

    public static int LomutoPartition(int[] arr, int left, int right) {
        int pivotValue = arr[right]; // naive lomuto
        // if want to avoid square time complexity, should choose pivot as middle of the array
        // left + (right - left) / 2;

        int i = left - 1; // start from head of array

        for(int j = left; j < right; j++){ // traverse from left to right - 1, not include pivot
            if (arr[j] < pivotValue){
                i++;
                swap(arr, i, j);
            }
        }
        // after the loop, i + 1 is position of pivot
        swap(arr, i + 1, right);
        return i + 1;
    }

    public static void print(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        // HoareQuickSort(arr, 0, arr.length - 1);
        LomutoQuickSort(arr, 0, arr.length - 1);
        print(arr);
    }
}
