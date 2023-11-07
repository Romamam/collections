package collections;

import collections.myhashmap.MyHashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {

    private MyHashMap<String, Integer> map;


    @BeforeEach
    public void setUp() {
        map = new MyHashMap<>();
    }

    @Test
    void testPutAndGet() {
        map.put("ABC", 12);
        assertEquals(12, map.get("ABC"));
        map.put(null, 12213);
        assertEquals(12213, map.get(null));
        assertNull(map.get("R"));
    }

    @Test
    void testRemove() {
    map.put("A", 12);
    map.put(null, 1);
    assertEquals(2, map.size());
    assertEquals(1, map.remove(null));
    assertEquals(12,map.remove("A"));
    assertNull(map.remove("B"));
    assertEquals(0, map.size());
    }

    @Test
    void testSize(){
        map.put("one", 1);
        map.put("two", 2);
        assertEquals(2, map.size());
        map.put("three", 3);
        assertEquals(3, map.size());
        map.remove("two");
        assertEquals(2, map.size());
    }

    @Test
    void containsKey(){
        map.put(null, 12);
        map.put("ASS", 121);
        map.put("AVC", 13);
        map.put("ABC", 12);
        assertTrue(map.containsKey(null));
        assertTrue(map.containsKey("ABC"));
        assertFalse(map.containsKey("AA"));
    }

}
