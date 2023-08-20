package pro.demo.services;

import org.junit.jupiter.api.Test;
import pro.demo.Exceptions.*;
import pro.demo.Exceptions.NullPointerException;


import java.util.Arrays;

import static pro.demo.services.StringListTestConstants.*;
import static org.junit.jupiter.api.Assertions.*;
class StringListImplTest {
    StringListImpl stringList = new StringListImpl();
    @Test
    void add() {
        assertTrue(stringList.isEmpty());
        stringList.add(FIRST);
        stringList.add(SECOND);
        stringList.add(THIRD);
        stringList.add(1, FOURTH);
        assertFalse(stringList.isEmpty());
        assertThrows(IndexOutOfRange.class,
                () -> stringList.add(15, FIRST));
        assertThrows(NullPointerException.class,
                () -> stringList.add(null));
        assertTrue(stringList.equals(OTHERLIST));
    }


    @Test
    void set() {
        stringList.add(FIRST);
        stringList.add(SECOND);
        stringList.add(THIRD);
        stringList.add(1, FOURTH);
        stringList.set(2, FIRST);
        assertNotEquals(THIRD, stringList.toArray()[2]);
        assertThrows(IndexOutOfRange.class,
                () -> stringList.set(15, FIRST));
        assertThrows(NullPointerException.class,
                () -> stringList.set(1, null));
        assertEquals(FIRST, stringList.get(2));
    }

    @Test
    void remove() {
        stringList.add(FIRST);
        stringList.add(SECOND);
        stringList.add(THIRD);
        stringList.add(1, FOURTH);
        stringList.remove(FIRST);
        stringList.remove(1);
        assertThrows(ElementNotFound.class,
                () -> stringList.remove(FIRST));
        assertThrows(IndexOutOfRange.class,
                () -> stringList.remove(3));
        assertTrue(stringList.equals(OTHERLIST2));
    }

    @Test
    void contains() {
        stringList.add(FIRST);
        stringList.add(SECOND);
        stringList.add(THIRD);
        stringList.add(1, FOURTH);
        assertTrue(stringList.contains(FOURTH));
        assertFalse(stringList.contains(FIVE));
    }

    @Test
    void indexOf() {
        stringList.add(FIRST);
        stringList.add(SECOND);
        stringList.add(THIRD);
        stringList.add(1, FOURTH);
        assertEquals(2,stringList.indexOf(SECOND));
        assertEquals(-1,stringList.indexOf(FIVE));
    }

    @Test
    void lastIndexOf() {
        stringList.add(FIRST);
        stringList.add(SECOND);
        stringList.add(THIRD);
        stringList.add(1, FOURTH);
        assertEquals(4,stringList.lastIndexOf(FIRST));
        assertEquals(-1,stringList.lastIndexOf(FIVE));
    }

    @Test
    void get() {
        stringList.add(FIRST);
        stringList.add(SECOND);
        stringList.add(THIRD);
        stringList.add(1, FOURTH);
        assertThrows(IndexOutOfRange.class,
                () -> stringList.get(5));
        assertEquals(SECOND, stringList.get(2));
    }

    @Test
    void Equals() {
        stringList.add(FIRST);
        stringList.add(SECOND);
        stringList.add(THIRD);
        stringList.add(1, FOURTH);
        assertThrows(NullPointerException.class,
                () -> stringList.equals(OTHERLIST3));
        assertFalse(stringList.equals(OTHERLIST2));
        assertTrue(stringList.equals(OTHERLIST));
    }

    @Test
    void size() {
        stringList.add(FIRST);
        stringList.add(SECOND);
        stringList.add(THIRD);
        stringList.add(1, FOURTH);
        assertNotEquals(1, stringList.size());
        assertEquals(4, stringList.size());
    }

    @Test
    void isEmpty() {
        assertTrue(stringList.isEmpty());
        stringList.add(FIRST);
        stringList.add(SECOND);
        stringList.add(THIRD);
        stringList.add(1, FOURTH);
        assertFalse(stringList.isEmpty());
    }

    @Test
    void clear() {
        stringList.add(FIRST);
        stringList.add(SECOND);
        stringList.add(THIRD);
        stringList.add(1, FOURTH);
        stringList.clear();
        assertEquals(0, stringList.size());
    }
    @Test
    void toArray() {
        stringList.add(FIRST);
        stringList.add(SECOND);
        stringList.add(THIRD);
        stringList.add(1, FOURTH);
        assertEquals(Arrays.toString(OTHERLIST.toArray()), Arrays.toString(stringList.toArray()));
        assertNotEquals(Arrays.toString(OTHERLIST2.toArray()), Arrays.toString(stringList.toArray()));
    }
}