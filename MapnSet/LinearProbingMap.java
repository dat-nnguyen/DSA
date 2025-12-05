package MapnSet;



public class LinearProbingMap<K, V> {

    static class Entry<K, V>{
        K key;
        V value;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity = 10;
    private int size = 0;

    private Entry<K, V>[] table;

    @SuppressWarnings("unchecked")
    public LinearProbingMap() {
        table = new Entry[capacity];
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    // --- PUT ---
    public void put(K key, V value) {
        // check if table is full
        if (size >= capacity / 2) {
            System.out.println("Need to resize!");
        }

        int i = getIndex(key);

        // --- PROBING LOOP ---
        while (table[i] != null) {
            // find same i (key) -> update value
            if (table[i].key.equals(key)) {
                table[i].value = value;
                return;
            }
            i = (i + 1) % capacity;
        }
        // table[i] == null -> insert new entry
        table[i] = new Entry<>(key, value);
        size++;
    }

    // --- GET ---
    public V get(K key) {
        int i = getIndex(key);

        while (table[i] != null) {
            if (table[i].key.equals(key)) return table[i].value;
            i = (i + 1) % capacity;
        }
        return null;
    }
}
