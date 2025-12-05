package MapnSet;


import java.util.ArrayList;

public class LinearMap {
    static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    static class ArraySimpleMap<K, V>{
        private ArrayList<Entry<K, V>> list = new ArrayList<>();

        public ArraySimpleMap(){
            this.list = new ArrayList<>();
        }

        public void put(K key, V value){
            // kiểm tra cặp key, value đã tồn tại chưa
            for (Entry<K, V> entry : list) {
                if (entry.key.equals(key)){
                    entry.value = value;// if exist, update the value
                    return;
                }
            }
            list.add(new Entry<>(key, value)); // if not, add to list
        }

        public V get(K key){
            // linear search
            for (Entry<K, V> entry : list) {
                if (entry.key.equals(key)){
                    return entry.value;
                }
            }
            return null; // not found
        }
    }
    public static void main(String[] args) {

    }
}
