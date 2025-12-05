package Sort;

/**
 * Time complexity: O(n^2)
 *
 * Better use in almost sorted array or small array
 */
public class BubbleSort {
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void BSort(int[] arr){
        int n = arr.length;
        boolean flag;
        for(int i = 0; i < n - 1; i++){
            flag = false;
            for(int j = i + 1; j < n; j++){
                if(arr[i] > arr[j]){
                    swap(arr, i, j);
                    flag = true;
                }
            }
            if(!flag) break;
        }
        return;
    }
    public static void main(String[] args) {
        int[] arr = {12312,3,2312,321,12345,343343,111,23,354,700};
        BSort(arr);
        for(int x: arr){
            System.out.print(x + " ");
        }
    }
}
