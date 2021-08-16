package homework.lab1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuperIntegerListImplTest {
    @Test
    public void addMultipleElements() {
        SuperIntegerList list = new SuperIntegerListImpl(new int[]{1});
        list.add(2);
        list.add(3);
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    public void getElements() {
        SuperIntegerList list = new SuperIntegerListImpl(new int[]{10, 20, -30});
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(-30, list.get(2));
    }

    @Test
    public void getElementAbroad() {
        SuperIntegerList list = new SuperIntegerListImpl(new int[]{10, 20, -30});
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(-2));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(3));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(4));
    }

    @Test
    public void removeByMultipleValue() {
        SuperIntegerList list = new SuperIntegerListImpl(new int[]{1, 1, -3, 2, 2, 4});
        list.removeByValue(1);
        assertEquals(-3, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(2, list.get(2));
        assertEquals(4, list.get(3));
    }

    @Test
    public void removeByNonExistValue() {
        SuperIntegerList list = new SuperIntegerListImpl(new int[]{1, 1, -3});
        list.removeByValue(2);
        assertEquals(1, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(-3, list.get(2));
    }

    @Test
    public void removeByIndex() {
        SuperIntegerList list = new SuperIntegerListImpl(new int[]{1, 1, -3});
        list.removeByIndex(2);
        assertEquals(1, list.get(0));
        assertEquals(1, list.get(1));
    }

    @Test
    public void removeByIndexAbroad() {
        SuperIntegerList list = new SuperIntegerListImpl(new int[]{10, 20, -30});
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.removeByIndex(-2));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.removeByIndex(3));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.removeByIndex(4));
    }
}