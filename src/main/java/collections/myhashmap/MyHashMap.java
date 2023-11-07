package collections.myhashmap;

import java.util.Map;
import java.util.Objects;

public class MyHashMap<K, V> {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75F;


    private int size = 0;
    double threshold;

    private Entry<K,V>[] table;
    public double loadFactor = 0.75;


    public MyHashMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public MyHashMap(int defaultInitialCapacity, float defaultLoadFactor) {
        table = new Entry[defaultInitialCapacity];
    }

    static class Entry<K, V> implements Map.Entry<K, V>{

        final K key;
        V value;
        Entry<K, V> next;
        final int hash;

        Entry(int hash, K key, V value, Entry<K, V> next){
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey(){
            return key;
        }

        public final V getValue(){
            return value;
        }
        public final int hashCode(){
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue){
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;

            return o instanceof Map.Entry<?, ?> e
                    && Objects.equals(key, e.getKey())
                    && Objects.equals(value, e.getValue());
        }
    }

    static final int hash(Object key){
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >> 16);
    }

    public V put(K key, V value){
        if(key == null){
            return putForNullKey(value);
        }
        int hash = hash(key.hashCode());
        int i = indexFor(hash, table.length);
        for(Entry<K, V> e = table[i]; e != null; e = e.next){
            Object k;
            if(e.hash == hash && ((k = e.key) == key || key.equals(k))){
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        addEntry(hash, key, value, i);
        return null;
    }

    private V putForNullKey(V value) {
        for(Entry<K, V> e = table[0]; e != null; e = e.next){
            if(e.key == null){
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        addEntry(0, null, value, 0);
        return null;
    }

    void addEntry(int hash, K key, V value, int index){
        threshold = table.length * loadFactor;
        if((size > threshold) && null != table[index]){
            resize(2 * table.length);
            hash = (null != key) ? key.hashCode() : 0;
            index = indexFor(hash, table.length);
        }
        Entry<K, V> e = table[index];
        table[index] = new Entry<>(hash, key, value, e);
        size++;
    }

    private void resize(int newCapacity) {
        Entry<K, V>[] newTable = new Entry[newCapacity];
        threshold = (newCapacity * loadFactor);

        for(Entry<K, V> e : table){
            while (e != null){
                Entry<K, V> next = e.next;
                int newIndex = indexFor(e.hash, newCapacity);
                e.next = newTable[newIndex];
                newTable[newIndex] = e;
                e = next;
            }
        }
        table = newTable;
    }

    static int indexFor(int h, int length) {
        return h & (length-1);
    }


    public V get(Object key){
        if(size == 0){
            for(Entry<K, V> e = table[0]; e != null; e = e.next) {
                if (e.key == null) {
                    return e.value;
                }
            }
        }
        int hash = (key == null) ? 0 : hash(key.hashCode());
        int index = indexFor(hash, table.length);
        for(Entry<K, V> e = table[index]; e != null; e = e.next){
            Object k = null;
            if(e.hash == hash && ((k = e.key) == key) || Objects.equals(key, k)){
                return e.value;
            }
        }
        return null;
    }

    public V remove(Object key){
        if(size == 0){
            return null;
        }
        if(key == null){
            Entry<K, V> e = table[0];
            if(e == null){
                return null;
            }
            if(e.key == null){
                table[0] = e.next;
                size--;
                return e.value;
            }
        }else {
            int hash = hash(key.hashCode());
            int index = indexFor(hash, table.length);

            Entry<K, V> prev = null;
            Entry<K, V> e = table[index];

            while (e != null){
                if(e.hash == hash && (key.equals(e.key))){
                    if(prev != null){
                        prev.next = e.next;
                    }
                    else {
                        table[index] = e.next;
                    }
                    size--;
                    return e.value;
                }
                prev = e;
                e = e.next;
            }
        }
        return null;
    }

    public boolean containsKey(Object key){
        if(size == 0){
            return false;
        }

        if(key == null){
            Entry<K, V> e = table[0];
            while(e != null){
                if(e.key == null){
                    return true;
                }
                e = e.next;
            }
            return false;
        }
        int hash = hash(key);
        int index = indexFor(hash, table.length);
        Entry<K, V> e = table[index];

        while (e != null){
            if(e.hash == hash && (key == e.key) || key.equals(e.key)){
                return true;
            }
            e = e.next;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public int capacity() {
        return table.length;
    }

}