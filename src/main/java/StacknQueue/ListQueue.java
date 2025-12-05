package StacknQueue;
import java.util.NoSuchElementException;
import List.Node;

public class ListQueue {
    private Node front;
    private Node rear;
    private int size; // Thêm biến size để quản lý kích thước (tùy chọn nhưng hữu ích)

    public ListQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    /**
     * Thêm một phần tử vào cuối hàng đợi (tail/rear).
     */
    public void enqueue(int data) {
        Node newNode = new Node(data);

        // Xử lý trường hợp queue đang rỗng
        if (isEmpty()) {
            // Nếu rỗng, phần tử mới là cả đầu và cuối
            front = newNode;
            rear = newNode;
        } else {
            // Nếu không rỗng, nối phần tử mới vào sau đuôi (rear) hiện tại
            rear.setNext(newNode);
            // Cập nhật lại đuôi là phần tử mới
            rear = newNode;
        }
        size++;
    }

    /**
     * Lấy và xóa bỏ phần tử ở đầu hàng đợi (head/front).
     */
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty. Cannot dequeue.");
        }

        // Lấy giá trị của phần tử đầu để trả về
        int valueToReturn = front.getValue();

        // Di chuyển con trỏ front tới phần tử kế tiếp
        front = front.getNext();

        // --- XỬ LÝ TRƯỜNG HỢP QUAN TRỌNG ---
        // Nếu sau khi dequeue, front trở thành null (tức là queue hết phần tử),
        // thì rear cũng phải được cập nhật về null để đảm bảo tính nhất quán.
        if (front == null) {
            rear = null;
        }

        size--;
        return valueToReturn;
    }

    /**
     * Xem phần tử ở đầu hàng đợi mà không xóa nó.
     */
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty. Cannot peek.");
        }
        return front.getValue();
    }

    /**
     * Kiểm tra xem queue có rỗng không.
     */
    public boolean isEmpty() {
        // Logic đúng: Queue rỗng khi front là null.
        return front == null;
    }

    /**
     * Trả về số lượng phần tử hiện có trong queue.
     */
    public int size() {
        return this.size;
    }
}