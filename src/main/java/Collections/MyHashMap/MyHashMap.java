package Collections.MyHashMap;
import Collections.MyLinkedList;

import java.util.LinkedList;
import java.util.Objects;

public class MyHashMap<K, V> {
    LinkedList<Entry>[] table = new LinkedList[8];
    public int size = 0;

    public MyHashMap(){}

    public void put(Key key, Value value){
        if(size >= table.length){
            resize();
        }

        int ix = getIndex(key) % table.length;

        if(table[ix] == null){
            table[ix] = new LinkedList<>();
            table[ix].add(new Entry(key, value));
            size++;
            return;
        }
        else{
            for(Entry entry : table[ix])
                if (entry.key.equals(key)) {
                    entry.value = value;
                    return;
                }
            }

        table[ix].add(new Entry(key, value));
        size++;
        return;
    }

    public Value get(Key key){
        int ix = getIndex(key) % table.length;

        if(table[ix] == null) {
            return null;
        }

        for (Entry entry : table[ix]) {
            if(entry.key.equals(key)){
                return entry.value;
            }
        }
        return null;
    }

    public void remove(Key key){
        if(key == null){
            return;
        }

        int ix = getIndex(key) % table.length;

        if(table[ix] == null){
            return;
        }

        Entry toRemove = null;

        for (Entry entry:table[ix]) {
            if(entry.key.equals(key)){
                toRemove = entry;
            }
        }

        if(toRemove == null){
            return;
        }
        table[ix].remove(toRemove);
    }

    public boolean containsKey(Key key){
        if(key == null){
            return false;
        }

        int ix = getIndex(key) % table.length;

        if(table[ix] == null){
            return false;
        }

        for(Entry entry : table[ix]){
            if(entry.key.equals(key)){
                return true;
            }
        }
        return false;
    }

    private int getIndex(Key key) {
        return key.hashCode();
    }


    private void resize() {
        LinkedList<Entry>[] oldTable = table;
        table = new LinkedList[size * 2];
        size = 0;

        for (int i = 0; i < oldTable.length; i++) {
            if(oldTable[i] == null){
                continue;
            }
            for(Entry entry : oldTable[i]){
                put(entry.key, entry.value);
            }
        }
    }
}