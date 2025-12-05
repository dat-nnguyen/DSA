package StacknQueue;

import List.Node;

public class ListStack {
    private Node top;
    private int size;

    public ListStack() {
        this.top = null;
        this.size = 0;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.setNext(top);
        top = newNode;
        size++;
    }
    public int pop() {
        if(isEmpty()){
            throw new RuntimeException("Stack Underflow: cannot pop from empty stack");
        }

        int valueToReturn = top.getValue();
        top = top.getNext();

        size--;
        return valueToReturn;
    }
    public int peek() {
        if(isEmpty()){
            throw new RuntimeException("Stack Underflow: cannot peek from empty stack");
        }
        return top.getValue();
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int length(){
        return size ;
    }

}
