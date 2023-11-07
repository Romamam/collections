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
        assertEquals(2, list.getSize());

        list.add(2, 5);
        list.add(1,18);

        assertEquals(4,list.getSize());
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
    void testRemoveElement() {
        list.add(2);
        list.add(15);
        list.add(8);
        assertTrue(list.remove(15));
        assertTrue(list.remove(8));
        assertEquals(1, list.getSize());
    }

    @Test
    void testRemoveByIndex(){
        list.add(0,12);
        list.add(1, 22);
        list.removeIndex(1);
        list.removeIndex(0);
       assertEquals(0, list.getSize());
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
        assertEquals(0, list.getSize());
        list.add(0, 1);
        list.add(1, 3);
        assertEquals(2, list.getSize());
    }

    @Test
    void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
        list.remove(1);
        assertTrue(list.isEmpty());
    }

    @Test
    void get() {
        list.add(0, 11);
        list.add(1, 13);
        assertEquals(11, list.get(0));
    }
}