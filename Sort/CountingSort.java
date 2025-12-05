package Sort;//package Sort;

import java.util.Scanner;

/**
 * counting sort is a algo sorting elements base on their frequency
 *
 * pros:
 *      fast: O(n + k) with k is the max range of input
 *      is a stable sorting algo
 * cons:
 *      high space complexity
 *      just use for positive integer
 *
 * WHEN USE COUNTING SORT?
 *      when sorting integer
 *      the range of integers is small
 */
public class CountingSort {

    public static int maxNum(int[] arr){
         int max = arr[0];
            for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
         return max;
    }
    public static int minNum(int[] arr){
        int min = arr[0];

        for (int j : arr) {
            if (j < min) {
                min = j;
            }
        }
         return min;
    }

     public static void Csort(int[] arr) {
        int min = minNum(arr);
        int max = maxNum(arr);

        int[] count = new int[max -  min + 1];
        for(int val: arr){
            count[val - min]++;
        }

        for ( int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] output = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];
            int positionInArray = count[current - min] - 1;
            output[positionInArray] = current;
            count[current - min]--;
        }
        System.arraycopy(output, 0, arr, 0, arr.length);
     }


    public static void main(String[] args){
         Scanner scanner = new Scanner(System.in);
         int[] arr = new int[10];
         System.out.print("Array before sorted: ");
         for(int i = 0; i < arr.length; i++){
             arr[i] = scanner.nextInt();
         }
         Csort(arr);
         System.out.print("Array after sorted: ");
         for(int x: arr){
             System.out.print(x + " ");
         }
    }
}
