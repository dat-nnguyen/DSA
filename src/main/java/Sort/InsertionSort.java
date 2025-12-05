package Sort;
public class InsertionSort {
    public static void Isort(int[] arr){
        int n =  arr.length;

        for(int i = 1; i < n; i++){
            int curr = arr[i];
            int position = i - 1;

            while(position >= 0 && arr[position] > curr){
                arr[position + 1] = arr[position]; // move element in position to right
                position--;
            }
            arr[position + 1] = curr;
        }
    }

    public static void main(String[] args) {
        int[] arr = {12312,3,2312,321,12345,343343,111,23,354,700};
        Isort(arr);
        System.out.print("Sorted array is: ");
        for(int x: arr){
            System.out.print(x + " ");
        }
    }
}
