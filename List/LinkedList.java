package List;

public class LinkedList {
    public static void printList(Node head) {
        Node temp = head;
        while (temp.getNext() != null) {
            System.out.print(temp.getValue() + " ");
            temp = temp.getNext();
        }
    }

    public static void insertNode(Node head, int data, int index, int length) {
        // insert head
        if (index == 0) {
            Node newHead = new Node(data);
            newHead.setNext(head);
            head = newHead;
        } // insert anywhere
        else if (index > 0 && index < length - 1) {
            Node newNode = new Node(data);
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                if (temp == null) return;
                temp = temp.getNext();

            }

            if (temp == null) return;
            newNode.setNext(temp.getNext());
            temp.setNext(newNode);

            // newNode.next = temp.next;
            // temp.next = newNode;
        }
        else {
            Node tail = new Node(data);
            if (head == null) return;

            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(tail);
            tail.setNext(null);

        } // insert tail
    }

    public static void deleteNode(Node head, int index) {
        Node prev = null;
        Node current = head;

        if (index == 0) return;
        for (int i = 0; i < index; i++) {
            prev = current;
            current = current.getNext();

            prev.setNext(current.getNext());
        }
    }
}


