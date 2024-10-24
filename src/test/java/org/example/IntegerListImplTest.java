package org.example;
import org.example.exception.IntegerAlreadyExist;
import org.example.exception.IntegerArrayIndexOutOfBoundsException;
import org.example.exception.IntegerNullPointerException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.IntegerConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplTest {
    private List<Integer> integerList;
    private int counter = 0;

    @BeforeEach
    public void setUp() {
        integerList = new ArrayList<>(6);
        integerList.add(5);
        integerList.add(14);
        integerList.add(24);
        integerList.add(32);
     }

    @Test
    public void testMethodThrowsNullPointerException() {
        Throwable exception = assertThrows(
                RuntimeException.class,
                () -> {
                    throw new IntegerNullPointerException("Число не может быть 0!");
                }
        );
        assertEquals("Число не может быть 0!", exception.getMessage());
    }

    @Test
    public void testMethodThrowsStringArrayIndexOutOfBoundsException() {
        Throwable exception = assertThrows(
                RuntimeException.class,
                () -> {
                    throw new IntegerArrayIndexOutOfBoundsException("Индекс числа выходит за пределы динамического массива!");
                }
        );
        assertEquals("Индекс числа выходит за пределы динамического массива!", exception.getMessage());
    }

    @Test
    public void testMethodThrowsArrayIndexOutOfBoundsException() {
        Throwable exception = assertThrows(
                RuntimeException.class,
                () -> {
                    throw new IntegerAlreadyExist("Данное число уже существует!");
                }
        );
        assertEquals("Данное число уже существует!", exception.getMessage());
    }

       @Test
    public void add() {
        integerList.add(NOT_EXIST_1);
        assertTrue(integerList.contains(NOT_EXIST_1));
    }

    @Test
    public void set() {
        integerList.set(3,NOT_EXIST_1);

        assertTrue(integerList.contains(NOT_EXIST_1));
        }


    @Test
    public void remove() {
        integerList.remove(EXIST);
        assertTrue(!integerList.contains(EXIST));
    }

    @Test
    public void contains() {
        assertTrue(integerList.contains(EXIST));
    }

    @Test
    public void indexOf() {
        int actual = integerList.indexOf(5);
        int expected = 0;
        assertEquals(actual, expected);
    }

    @Test
    public void lastIndexOf() {
        int actual = integerList.lastIndexOf(32);
        int expected = 3;
        assertEquals(actual, expected);
    }

    @Test
    public void get() {
        Integer actual = integerList.get(3);
        Integer expected = 32;
       assertEquals(actual, expected);
    }
    @Test
    public void size() {
        int actual = integerList.size();
        int expected = 4;
        assertEquals(actual, expected);
    }

    @Test
    public void isEmpty() {
        integerList.clear();
        assertTrue(integerList.isEmpty());
    }

    @Test
    public void clear() {
        integerList.clear();
        assertTrue(integerList.isEmpty());
    }

    @Test
    public void toArray() {
        Integer[] expectedStringArray = {5,14,24,32};
        assertTrue(Arrays.equals(expectedStringArray, integerList.toArray()));
    }
}