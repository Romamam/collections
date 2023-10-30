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
        assertTrue(list.add(1));
        assertTrue(list.add(2));
        assertEquals(2, list.getSize());
    }

    @Test
    void testRemove() {
        list.add(1);
        list.add(2);
        assertTrue(list.remove(1));
        assertEquals(1,list.getSize());
        assertFalse(list.remove(3));

    }

    @Test
    void testContains() {
        assertFalse(list.contains(1));

        list.add(1);
        list.add(2);

        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertFalse(list.contains(3));
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
    }

    @Test
    void get() {
        list.add(1);
        list.add(2);
        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
    }
}