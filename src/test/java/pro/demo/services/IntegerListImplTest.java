package pro.demo.services;

import org.junit.jupiter.api.Test;
import pro.demo.Exceptions.*;
import pro.demo.Exceptions.NullPointerException;


import java.util.Arrays;

import static pro.demo.IntegerListTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;
class IntegerListImplTest {
    IntegerListImpl integerList = new IntegerListImpl();

    @Test
    void add() {
        assertTrue(integerList.isEmpty());
        integerList.add(FIRST);
        integerList.add(SECOND);
        integerList.add(THIRD);
        integerList.add(1, FOURTH);
        assertFalse(integerList.isEmpty());
        assertThrows(IndexOutOfRange.class,
                () -> integerList.add(15, FIRST));
        assertThrows(NullPointerException.class,
                () -> integerList.add(null));
        assertTrue(integerList.equals(OTHERLIST));
    }


    @Test
    void set() {
        integerList.add(FIRST);
        integerList.add(SECOND);
        integerList.add(THIRD);
        integerList.add(1, FOURTH);
        integerList.set(2, FIRST);
        assertNotEquals(THIRD, integerList.toArray()[2]);
        assertThrows(IndexOutOfRange.class,
                () -> integerList.set(15, FIRST));
        assertThrows(NullPointerException.class,
                () -> integerList.set(1, null));
        assertEquals(FIRST, integerList.get(2));
    }

    @Test
    void remove() {
        integerList.add(FIRST);
        integerList.add(SECOND);
        integerList.add(THIRD);
        integerList.add(1, FOURTH);
        integerList.remove(FIRST);
        integerList.removeByIndex(1);
        assertThrows(ElementNotFound.class,
                () -> integerList.remove(FIRST));
        assertThrows(IndexOutOfRange.class,
                () -> integerList.removeByIndex(3));
        assertTrue(integerList.equals(OTHERLIST2));
    }

    @Test
    void contains() {
        integerList.add(FIRST);
        integerList.add(SECOND);
        integerList.add(THIRD);
        integerList.add(1, FOURTH);
        assertTrue(integerList.contains(FOURTH));
        assertFalse(integerList.contains(FIVE));
    }

    @Test
    void indexOf() {
        integerList.add(FIRST);
        integerList.add(SECOND);
        integerList.add(THIRD);
        integerList.add(1, FOURTH);
        assertEquals(2, integerList.indexOf(SECOND));
        assertEquals(-1, integerList.indexOf(FIVE));
    }

    @Test
    void lastIndexOf() {
        integerList.add(FIRST);
        integerList.add(SECOND);
        integerList.add(THIRD);
        integerList.add(1, FOURTH);
        assertEquals(4, integerList.lastIndexOf(FIRST));
        assertEquals(-1, integerList.lastIndexOf(FIVE));
    }

    @Test
    void get() {
        integerList.add(FIRST);
        integerList.add(SECOND);
        integerList.add(THIRD);
        integerList.add(1, FOURTH);
        assertThrows(IndexOutOfRange.class,
                () -> integerList.get(5));
        assertEquals(SECOND, integerList.get(2));
    }

    @Test
    void Equals() {
        integerList.add(FIRST);
        integerList.add(SECOND);
        integerList.add(THIRD);
        integerList.add(1, FOURTH);
        assertThrows(NullPointerException.class,
                () -> integerList.equals(OTHERLIST3));
        assertFalse(integerList.equals(OTHERLIST2));
        assertTrue(integerList.equals(OTHERLIST));
    }

    @Test
    void size() {
        integerList.add(FIRST);
        integerList.add(SECOND);
        integerList.add(THIRD);
        integerList.add(1, FOURTH);
        assertNotEquals(1, integerList.size());
        assertEquals(4, integerList.size());
    }

    @Test
    void isEmpty() {
        assertTrue(integerList.isEmpty());
        integerList.add(FIRST);
        integerList.add(SECOND);
        integerList.add(THIRD);
        integerList.add(1, FOURTH);
        assertFalse(integerList.isEmpty());
    }

    @Test
    void clear() {
        integerList.add(FIRST);
        integerList.add(SECOND);
        integerList.add(THIRD);
        integerList.add(1, FOURTH);
        integerList.clear();
        assertEquals(0, integerList.size());
    }

    @Test
    void toArray() {
        integerList.add(FIRST);
        integerList.add(SECOND);
        integerList.add(THIRD);
        integerList.add(1, FOURTH);
        assertEquals(Arrays.toString(OTHERLIST.toArray()), Arrays.toString(integerList.toArray()));
        assertNotEquals(Arrays.toString(OTHERLIST2.toArray()), Arrays.toString(integerList.toArray()));
    }

    @Test
    void sortTest() {
        /*
            sortBubble = 146948
            sortSelection = 27670
            sortInsertion = 31289
            sortSelection is faster
         */
        integerList.randomArrays();
        IntegerListImpl integerList2 = new IntegerListImpl(Arrays.asList(integerList.toArray()));
        IntegerListImpl integerList3 = new IntegerListImpl(Arrays.asList(integerList.toArray()));
        IntegerListImpl integerList4 = new IntegerListImpl(Arrays.asList(integerList.toArray()));
        integerList.sortBubble();
        integerList2.sortSelection();
        integerList3.sortInsertion();
        integerList4.quickSort();
        assertEquals(Arrays.toString(integerList2.toArray()), Arrays.toString(integerList.toArray()));
        assertEquals(Arrays.toString(integerList2.toArray()), Arrays.toString(integerList3.toArray()));
        assertEquals(Arrays.toString(integerList4.toArray()), Arrays.toString(integerList3.toArray()));
    }
}