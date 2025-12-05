package MapnSet;

import java.util.ArrayList;

import java.util.Scanner;

public class MyHashMap<K, V> {
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

    private ArrayList<Node<K, V>> bucket = new ArrayList<>();
    private int slots;// size of bucket
    private int size;// real size of map

    public MyHashMap() {
        this.slots = 10;
        this.size = 0;
        this.bucket = new ArrayList<>(slots);

        for(int i = 0; i < slots; i++){
            bucket.add(null);
        }
    }

    // --- HASH FUNCTION ---
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        // hash code must be in range [0, 9]
        return Math.abs(hashCode) % slots;
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        Node<K, V> head = bucket.get(index);
        Node<K, V> curr = head;

        while(curr != null) {
            if (curr.key.equals(key)) {
                curr.value = value;
                return;
            }
            curr = curr.next;
        }

        // --- COLLISION RESOLVE ---
        size++;
        Node<K, V> newNode = new Node<>(key, value); // add to head

        newNode.next = head;
        bucket.set(index, newNode);
    }
    public V get(K key) {
        int index = getBucketIndex(key);
        Node<K, V> head = bucket.get(index);

        Node<K, V> curr = head;
        while(curr != null) {
            if (curr.key.equals(key)) return curr.value;
            curr = curr.next;
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = text.split("");

        for(String w: words) {
            map.put(w, 1);
        }
        System.out.println(map);
    }
}
