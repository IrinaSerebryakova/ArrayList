package org.example;
import org.example.exception.StringAlreadyExist;
import org.example.exception.StringArrayIndexOutOfBoundsException;
import org.example.exception.StringNullPointerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.StringConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class StringListImplTest {
    private List<String> stringList;
    private int counter = 0;

    @BeforeEach
    public void setUp() {
        stringList = new ArrayList<>(6);
        stringList.add("Белка песенки поёт");
        stringList.add("Да орешки всё грызёт");
        stringList.add("А орешки не простые");
        stringList.add("У них скорлупки золотые");
     }

    @Test
    public void testMethodThrowsNullPointerException() {
        Throwable exception = assertThrows(
                RuntimeException.class,
                () -> {
                    throw new StringNullPointerException("Строка не может быть null!");
                }
        );
        assertEquals("Строка не может быть null!", exception.getMessage());
    }

    @Test
    public void testMethodThrowsStringArrayIndexOutOfBoundsException() {
        Throwable exception = assertThrows(
                RuntimeException.class,
                () -> {
                    throw new StringArrayIndexOutOfBoundsException("Индекс строки выходит за пределы динамического массива!");
                }
        );
        assertEquals("Индекс строки выходит за пределы динамического массива!", exception.getMessage());
    }

    @Test
    public void testMethodThrowsArrayIndexOutOfBoundsException() {
        Throwable exception = assertThrows(
                RuntimeException.class,
                () -> {
                    throw new StringAlreadyExist("Данная строка уже существует!");
                }
        );
        assertEquals("Данная строка уже существует!", exception.getMessage());
    }

       @Test
    public void add() {
        stringList.add(STR_NOT_EXIST_1);
        stringList.add(STR_NOT_EXIST_2);
        assertTrue(stringList.contains(STR_NOT_EXIST_1));
        assertTrue(stringList.contains(STR_NOT_EXIST_2));
    }

    @Test
    public void set() {
        stringList.set(INDEX_NORMAL,STR_NOT_EXIST_1);
        stringList.set(INDEX_NORMAL + 1,STR_NOT_EXIST_2);

        assertTrue(stringList.contains(EXIST));
        assertTrue(stringList.contains(STR_NOT_EXIST_1));
        assertTrue(stringList.contains(STR_NOT_EXIST_2));
    }

    @Test
    public void remove() {
        stringList.remove(EXIST);
        assertTrue(!stringList.contains(EXIST));
    }

    @Test
    public void contains() {
        assertTrue(stringList.contains(EXIST));
    }

    @Test
    public void indexOf() {
        int actual = stringList.indexOf("Белка песенки поёт");
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void lastIndexOf() {
        int actual = stringList.lastIndexOf("У них скорлупки золотые");
        int expected = 3;
        assertEquals(actual, expected);
    }

    @Test
    public void get() {
       String actual = stringList.get(3);
       String expected = "У них скорлупки золотые";
       assertEquals(actual, expected);
    }
    @Test
    public void size() {
        int actual = stringList.size();
        int expected = 4;
        assertEquals(actual, expected);
    }

    @Test
    public void isEmpty() {
        stringList.clear();
        assertTrue(stringList.isEmpty());
    }

    @Test
    public void clear() {
        stringList.clear();
        assertTrue(stringList.isEmpty());
    }

    @Test
    public void toArray() {
        String[] expectedStringArray = {"Белка песенки поёт","Да орешки всё грызёт","А орешки не простые","У них скорлупки золотые"};
        assertTrue(Arrays.equals(expectedStringArray, stringList.toArray()));
    }
}