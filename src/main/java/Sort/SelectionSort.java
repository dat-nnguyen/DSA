package Sort;
public class SelectionSort {
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void sSort(int[] arr) {
        int n = arr.length;

        for(int i = 0; i < n - 1; i++){
            int minIndex = i;

            for(int j = i + 1; j < n; j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }
    public static void main(String[] args) {
        int[] arr = {12312,3,2312,321,12345,343343,111,23,354,700};
        sSort(arr);
        System.out.print("Sorted array is: ");
        for(int x: arr){
            System.out.print(x + " ");
        }
    }
}
