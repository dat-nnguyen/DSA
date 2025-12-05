package StacknQueue;
public class ArrayStack {

    private int[] myStack;
    private int topIndex;
    private int MAX_SIZE;

    // Constructor không thay đổi
    public ArrayStack(int maxSize) {
        this.MAX_SIZE = maxSize;
        this.myStack = new int[MAX_SIZE];
        this.topIndex = -1;
    }

    /**
     * Thêm một phần tử vào đỉnh stack.
     * Ném ra ngoại lệ nếu stack đầy.
     */
    public void push(int value) {
        if (isFull()) {
            // Ném ra Exception thay vì chỉ in ra console.
            throw new RuntimeException("Stack Overflow: Cannot push element " + value);
        }
        // Có thể gộp 2 dòng: myStack[++topIndex] = value;
        topIndex++;
        myStack[topIndex] = value;
    }

    /**
     * Lấy và xóa bỏ phần tử ở đỉnh stack.
     * Thay đổi kiểu trả về thành int.
     * Ném ra ngoại lệ nếu stack rỗng.
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow: Cannot pop from an empty stack");
        }
        // Lấy giá trị tại đỉnh, sau đó giảm topIndex.
        return myStack[topIndex--];
    }

    /**
     * Xem phần tử ở đỉnh stack mà không xóa nó.
     * Thay đổi kiểu trả về thành int.
     * Ném ra ngoại lệ nếu stack rỗng.
     */
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow: Cannot peek into an empty stack");
        }
        return myStack[topIndex];
    }

    /**
     * Kiểm tra stack có rỗng không.
     */
    public boolean isEmpty() {
        return topIndex == -1;
    }

    /**
     * Kiểm tra stack có đầy không.
     */
    public boolean isFull() {
        return topIndex == MAX_SIZE - 1;
    }

    /**
     * Trả về số lượng phần tử hiện có trong stack.
     */
    public int size() {
        return topIndex + 1;
    }
    public static void main(String[] args) {
        ArrayStack stack1 = new ArrayStack(10);
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.pop();

        System.out.println(stack1.peek());
    }
}