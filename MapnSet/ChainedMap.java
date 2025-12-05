package MapnSet;

public class ChainedMap {
    static class Node<K, V>{
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
    static class ListSimpleMap<K, V>{
        private Node<K, V> head;

        public void put(K key, V value){
            if (head == null) { // if empty
                head = new Node<>(key, value);
                return;
            }

            Node<K, V> curr = head;

            while (curr != null) {
                if (curr.key.equals(key)){
                    curr.value = value;
                    return;
                }
                if (curr.next == null) break;
                curr = curr.next;
            }
            curr.next = new Node<>(key, value);
        }

        public V get(K key){
            Node<K, V> curr = head;
            while (curr != null) {
                if (curr.key.equals(key)) return curr.value;
                curr = curr.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {

    }
}
