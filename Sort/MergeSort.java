package Sort;
public class MergeSort {
    /**
     *
     * @param arr
     * @param left
     * @param right
     * ======TOP-DOWN MERGE SORT======
     */
    public static void TopDownMergeSort(int[] arr, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;// find the middle of the array

        TopDownMergeSort(arr, left, mid); // recursive call for left side
        TopDownMergeSort(arr, mid + 1, right); // recursive call for right side
        Merge(arr, left, mid, right);
    }

    public static void Merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] Left = new int[n1];
        int[] Right = new int[n2];
        // initialize data to temporary array
        for(int i = 0; i < n1; i++) Left[i] = arr[left + i];
        for(int i = 0; i < n2; i++) Right[i] = arr[mid + 1 + i];

        // merging
        int i = 0;
        int j = 0;
        int k = left;

        while(i < n1 && j < n2) {
            if (Left[i] <= Right[j]) {
                arr[k] = Left[i];
                i++;
            } else  {
                arr[k] = Right[j];
                j++;
            }
            k++;
        }

        while(i < n1) arr[k++] = Left[i++];
        while(j < n2) arr[k++] = Right[j++];
    }

    /**
     *
     * @param arr
     * @param left
     * @param right
     * =====BOTTOM-UP MERGE SORT======
     */
    public static void BottomUpMergeSort(int[] arr, int left, int right) {
        int n = arr.length;
        // Increase size of sub array with the first for loop
        for(int size = 1; size < n; size *= 2){

            // with the second for loop, traverse through array from left
            for(int leftStart = 0; leftStart < n - 1; leftStart += 2 * size){
                //find the middle of the array
                int mid = Math.min(leftStart + size -1, n - 1);
                int rightEnd = Math.max(leftStart + 2 * size - 1, n - 1);

                //only merging if right array exist, mid < rightEnd;
                if(mid < rightEnd){
                    Merge(arr, leftStart, mid, rightEnd);
                }
            }
        }
    }

    /**
     * ==========HYBRID MERGE SORT=========
     * MERGE SORT + INSERTION SORT
     */

    public static void HybridMergeSort(int[] arr, int left, int right) {
        final int INSERTION_SORT_CUTOFF = 16;

        int size = right - left + 1;
        if (size <= INSERTION_SORT_CUTOFF) {
            insertionSort(arr, left, right);
            return;
        }

        int mid = left + (right - left) / 2;
        HybridMergeSort(arr, left, mid);
        HybridMergeSort(arr, mid + 1, right);

        Merge(arr, left, mid, right);
    }

    public static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int curr = arr[i];
            int j = i - 1;

            while (j >= left && curr < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = curr;w
        }
    }
}
