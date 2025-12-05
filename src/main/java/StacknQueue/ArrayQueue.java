package StacknQueue;

/**
 * here I use circular array which better than normal array
 */
public class ArrayQueue {
    private int[] queueArray;
    private int front;
    private int rear;
    private int MAX_SIZE;
    private int currentSize;

    public ArrayQueue(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
        queueArray = new int[MAX_SIZE];
        front = 0;
        rear = 0;
        currentSize = 0;
    }

    public void enqueue(int data) {
        if(isFull()){
            throw new RuntimeException("Queue is full");
        }

        queueArray[rear] = data;
        rear = (rear + 1) % MAX_SIZE;
        currentSize++;
    }

    public int dequeue() {
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        int valueToReturn = queueArray[front];
        front = (front + 1) % MAX_SIZE;
        currentSize--;
        return valueToReturn;
    }

    public int peek() {
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return queueArray[front];
    }
    public boolean isEmpty() {
        return currentSize == 0;
    }
    public boolean isFull() {
       return currentSize == MAX_SIZE;
    }

}
