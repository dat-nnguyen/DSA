package StacknQueue;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {

    // --- CLASS MIN HEAP (Gốc là nhỏ nhất) ---
    static class MinHeap {
        protected List<Integer> heap = new ArrayList<>();

        void swap(int i, int j) {
            int temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }

        public int parent(int i) { return (i - 1) / 2; }
        public int leftChild(int i) { return (2 * i) + 1; }
        public int rightChild(int i) { return (2 * i) + 2; }

        public void push(int value) {
            heap.add(value);
            heapifyUp(heap.size() - 1);
        }

        public void heapifyUp(int i) {
            // MinHeap: Đổi chỗ nếu CON < CHA
            while (i > 0 && heap.get(i) < heap.get(parent(i))) {
                int p = parent(i);
                swap(i, p);
                i = p;
            }
        }

        public int pop() { // Đã bỏ tham số int i (không cần thiết vì pop luôn lấy gốc)
            if (heap.isEmpty()) return 0; // Hoặc throw exception

            int root = heap.get(0); // Lấy giá trị gốc

            // Xóa phần tử cuối cùng khỏi mảng
            int lastElement = heap.remove(heap.size() - 1);

            // Nếu mảng vẫn còn phần tử (tức là ban đầu có > 1 phần tử)
            if (!heap.isEmpty()) {
                heap.set(0, lastElement); // Đưa phần tử cuối lên đầu
                heapifyDown(0);           // Vun xuống
            }

            return root;
        }

        public void heapifyDown(int i) {
            int l = leftChild(i);
            int r = rightChild(i);
            int smallest = i;

            // MinHeap: Tìm phần tử NHỎ NHẤT trong 3 (Cha, Trái, Phải)
            // Sửa lỗi logic: l < heap.size() và dấu <
            if (l < heap.size() && heap.get(l) < heap.get(smallest)) {
                smallest = l;
            }

            if (r < heap.size() && heap.get(r) < heap.get(smallest)) {
                smallest = r;
            }

            if (smallest != i) {
                swap(i, smallest);
                heapifyDown(smallest);
            }
        }

        public int peek() {
            if (!heap.isEmpty()) return heap.get(0);
            return 0;
        }
    }

    // --- CLASS MAX HEAP (Gốc là lớn nhất) ---
    static class MaxHeap {
        protected List<Integer> heap = new ArrayList<>();

        void swap(int i, int j) {
            int temp = heap.get(i);
            heap.set(i, heap.get(j));
            heap.set(j, temp);
        }

        public int parent(int i) { return (i - 1) / 2; }
        public int leftChild(int i) { return (2 * i) + 1; }
        public int rightChild(int i) { return (2 * i) + 2; }

        public void push(int value) {
            heap.add(value);
            heapifyUp(heap.size() - 1);
        }

        public void heapifyUp(int i) {
            // MaxHeap: Đổi chỗ nếu CON > CHA
            while (i > 0 && heap.get(i) > heap.get(parent(i))) {
                int p = parent(i);
                swap(i, p);
                i = p;
            }
        }

        public int pop() {
            if (heap.isEmpty()) return 0;

            int max = heap.get(0);
            int lastElement = heap.remove(heap.size() - 1); // Xóa phần tử cuối

            if (!heap.isEmpty()) {
                heap.set(0, lastElement);
                heapifyDown(0);
            }
            return max;
        }

        public void heapifyDown(int i) {
            int largest = i;
            int left = leftChild(i);
            int right = rightChild(i);

            // MaxHeap: Tìm phần tử LỚN NHẤT
            if (left < heap.size() && heap.get(left) > heap.get(largest)) {
                largest = left;
            }

            if (right < heap.size() && heap.get(right) > heap.get(largest)) {
                largest = right;
            }

            if (largest != i) {
                swap(i, largest);
                heapifyDown(largest);
            }
        }

        public int peek() {
            if (!heap.isEmpty()) return heap.get(0);
            return 0;
        }
    }
}