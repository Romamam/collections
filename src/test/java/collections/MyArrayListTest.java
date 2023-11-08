package collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    private MyArrayList<Integer> list;

    @BeforeEach
    public void setUp(){
        list = new MyArrayList<>();
    }

    @Test
    void testAdd() {
        assertTrue(list.add(2));
        assertTrue(list.add(1));
        list.add(1, 22);
        assertEquals(22, list.get(1));
        assertEquals(3, list.getSize());
    }

    @Test
    void testRemove() {
        list.add(1);
        list.add(2);
        list.add(null);
        assertTrue(list.remove(1));
        assertEquals(2,list.getSize());
        assertTrue(list.remove(null));
        assertFalse(list.remove(3));
        assertFalse(list.remove(5));

    }

    @Test
    void testContains() {
        assertFalse(list.contains(1));

        list.add(1);
        list.add(2);
        list.add(null);

        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertFalse(list.contains(3));
        assertTrue(list.contains(null));
    }

    @Test
    void testSize() {
        assertEquals(0, list.getSize());

        list.add(1);
        list.add(2);

        assertEquals(2, list.getSize());
    }

    @Test
    void testIsEmpty() {
        assertTrue(list.isEmpty());

        list.add(1);

        assertFalse(list.isEmpty());

        list.remove(1);
        assertTrue(list.isEmpty());
        list.add(null);
        assertFalse(list.isEmpty());
    }

    @Test
    void get() {
        list.add(1);
        list.add(2);
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
    }
}