package HashMap;

import java.util.Arrays;

public class MyHashMap<K, V> {
    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private final int size = 16;
    private Node[] array;
    private int hashMapSize = 0;

    public MyHashMap() {
        array = new Node[size];
    }

    public void put(K key, V value) {
        int hash = key.hashCode() % size;
        Node<K, V> entry = array[hash];

        if (entry == null) {
            array[hash] = new Node<>(key, value);
        } else {
            while (entry.next != null) {
                if (entry.getKey() == key) {
                    entry.setValue(value);
                    return;
                }
                entry = entry.next;
            }

            if (entry.getKey() == key) {
                entry.setValue(value);
                return;
            }
            entry.next = new Node<K, V>(key, value);
        }
        hashMapSize++;
    }

    public V get(K key) {
        int hash = key.hashCode() % size;
        Node<K, V> entry = array[hash];

        if (entry == null) {
            return null;
        }

        while (entry != null) {
            if (entry.getKey() == key) {
                return entry.getValue();
            }
            entry = entry.next;
        }
        return null;
    }

    public void remove(K key) {
        int hash = key.hashCode() % size;
        Node<K, V> entry = array[hash];
        Node<K, V> prev = entry;

        if (entry.getKey() == key) {
            array[hash] = entry.next;
            entry.next = null;
        }

        entry = entry.next;

        while (entry != null) {
            if (entry.getKey() == key) {
                prev.next = entry.next;
                entry.next = null;
            }
            prev = entry;
            entry = entry.next;
        }
        hashMapSize--;
    }

    public void clear() {
        Arrays.fill(array, null);
        hashMapSize = 0;
    }

    public int size() {
        return hashMapSize;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (array[i] != null) {
                Node<K, V> entry = array[i];
                while (entry != null) {
                    sb.append("Key - ").append(entry.key).append(", ").append("Value - ").append(entry.value).append("\n");
                    entry = entry.next;
                }
            }
        }
        return sb.toString();
    }
}
