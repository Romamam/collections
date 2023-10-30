package collections;

import collections.myHashMap.Key;
import collections.myHashMap.MyHashMap;
import collections.myHashMap.Value;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class MyHashMapTest {

    private MyHashMap<String, Integer> map;


    @BeforeEach
    public void setUp() {
        map = new MyHashMap<>();
    }

    @Test
    void testPutAndGet() {
        map.put(new Key(1), new Value(1111));
        map.put(new Key(22), new Value(222));
        map.put(new Key(14), new Value(3333));
        assertEquals(1111,map.get(new Key(1)).getValue());
        assertEquals(222,map.get(new Key(22)).getValue());

    }

    @Test
    void remove() {
        map.put(new Key(1), new Value(1111));
        map.put(new Key(22), new Value(222));
        map.remove(new Key(1));
        map.remove(new Key(22));
        assertFalse(map.containsKey(new Key(1)));
        assertFalse(map.containsKey(new Key(22)));
    }
}
