package Sort;

public class HeapSort {
    public static void heapSort(int[] arr){
        int n = arr.length;
        heapify(arr);    // build max heap

        for(int i = n - 1; i > 0; i--){ // swap last element to front
            swap(arr, 0, i);
            // sift down root with new heap
            siftDown(arr, 0, i);
        }
    }

    public static void heapify(int[] arr){
        int n = arr.length;
        // go from the last parent node to root
        for(int i = (n / 2) - 1; i >= 0; i--){
            siftDown(arr, i, n);
        }
    }

    /**
     *
     * @param arr array
     * @param i root index
     * @param n size of heap
     */
    public static void siftDown(int[] arr, int i, int n){
        int largerChild;

        while((2 * i + 1) < n){
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            largerChild = left; // suppose that left child is bigger

            if(right < n && arr[right] > arr[left]){
                largerChild = right;
            }
            // if parent(i) >= lagerChile -> break;
            if(arr[i] >= arr[largerChild]){
                break;
            } else {
                swap(arr, i , largerChild);
            }
            i = largerChild;
        }
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
