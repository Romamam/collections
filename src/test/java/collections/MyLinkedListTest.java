package collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    private MyLinkedList<Integer> list;

    @BeforeEach
    public void setUp(){
        list = new MyLinkedList<>();
    }

    @Test
    void testAdd() {
        list.add(1);
        list.add(2);
        assertEquals(2, list.size());

        list.add(2, 5);
        list.add(1,18);

        assertEquals(4,list.size());
        assertEquals(18, list.get(1));
    }

    @Test
    void testSet() {
        list.add(1);
        list.add(2);
        list.set(0,3);
        assertEquals(3, list.get(0));
    }

    @Test
    void testRemove() {
        list.add(1);
        list.add(2);
        list.add(2,5);
        assertEquals(1, list.remove(0));
        assertEquals(2, list.size());
    }

    @Test
    void testContains() {
        list.add(1);
        list.add(2);
        assertTrue(list.contains(1));
        assertFalse(list.contains(3));
    }

    @Test
    void testSize() {
        assertEquals(0, list.size());
        list.add(0, 1);
        list.add(1, 3);
        assertEquals(2, list.size());
    }

    @Test
    void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
        list.remove(0);
        assertTrue(list.isEmpty());
    }

    @Test
    void get() {
        list.add(0, 11);
        list.add(1, 13);
        assertEquals(11, list.get(0));
    }
}