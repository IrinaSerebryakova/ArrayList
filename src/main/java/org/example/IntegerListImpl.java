package org.example;

import org.example.exception.IntegerAlreadyExist;
import org.example.exception.IntegerArrayIndexOutOfBoundsException;
import org.example.exception.IntegerNullPointerException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class IntegerListImpl implements IntegerList {
    private List<Integer> integerList;
    int counter = 0;
    public static Integer[] random = new Integer[100_000];
    public IntegerListImpl() {
        integerList = new ArrayList<>(6);
    }

    public boolean checkIntegerNotNull(Integer item){
        if (item != 0) {
            return true;
        }else {
            throw new IntegerNullPointerException("Число не может быть 0!");
        }
    }

    public boolean checkIndexNoLessNullOrMoreThanSizeOfList(int index) {
        if (!(index > integerList.size()) || !(index < 0)) {
           return true;
        }else {
            throw new IntegerArrayIndexOutOfBoundsException("Индекс числа выходит за пределы динамического массива!");
        }
    }

    public boolean checkIntegerAlreadyExist(Integer item){
        if (integerList.contains(item)){
            throw new IntegerAlreadyExist("Данное число уже существует!");
        }
        return true;
    }

    public int counter(){
        for (Integer i : integerList) {
            if (i != 0) {
                counter++;
            }
        }
        return counter;
    }

    public void toMoreVolumeArrayList(){
        ArrayList<Integer> secondList = new ArrayList<>(integerList.size() * 3 / 2 + 1);
        for (Integer i : integerList) {
            secondList.add(i);
        }
        integerList = new ArrayList<>(secondList);
    }

    @Override
    public Integer add(Integer item) {
        if (checkIntegerNotNull(item) && checkIntegerAlreadyExist(item)) {
            counter();
            if (counter == integerList.size()) {
                toMoreVolumeArrayList();
            }
            integerList.add(item);
        }
        return integerList.get(integerList.indexOf(item));
    }

    @Override
    public Integer add(int index, Integer i) {
        if (checkIntegerNotNull(i) && checkIntegerAlreadyExist(i)) {
            if (checkIndexNoLessNullOrMoreThanSizeOfList(index)) {
                counter();
                if (counter == integerList.size()) {
                    toMoreVolumeArrayList();
                    }
                integerList.add(index, i);
            }
        }
        return integerList.get(index);
    }

    @Override
    public Integer set(int index, Integer i) {
        if (checkIntegerNotNull(i) && checkIntegerAlreadyExist(i)) {
            if (checkIndexNoLessNullOrMoreThanSizeOfList(index)) {
                counter();
                try {
                    if (counter == integerList.size()) {
                        toMoreVolumeArrayList();
                        integerList.set(index, i);
                    }
                }
                catch(IndexOutOfBoundsException e){
                }
            }
        }
        return integerList.get(index);
    }

    @Override
    public Integer remove(Integer i) {
        Integer removed = null;
        if (checkIntegerNotNull(i)) {
            removed = integerList.get(integerList.indexOf(i));
            integerList.remove(i);
        }
        return removed;
    }

    @Override
    public Integer remove(int index) {
        Integer removed = 0;
        if (checkIndexNoLessNullOrMoreThanSizeOfList(index)) {
            removed = integerList.get(index);
            integerList.remove(index);
        }
        return removed;
    }

    @Override
    public int indexOf(Integer i) {
        int index = -1;
        if (checkIntegerNotNull(i)) {
            index = integerList.indexOf(i);
        }
        return index;
    }

    @Override
    public int lastIndexOf(Integer i) {
        int lastIndex = -1;
        if (checkIntegerNotNull(i)) {
            lastIndex = integerList.lastIndexOf(i);
        }
        return lastIndex;
    }

    @Override
    public Integer get(int index) {
        Integer request = null;
        if (checkIndexNoLessNullOrMoreThanSizeOfList(index)) {
            request = integerList.get(index);
        }
        return request;
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return integerList.equals(otherList);
    }

    @Override
    public int size() {
        if (integerList == null) {
            throw new NullPointerException();
        }
        return integerList.size();
    }

    @Override
    public boolean isEmpty() {
        return integerList.isEmpty();
    }

    @Override
    public void clear() {
        integerList.clear();
    }

    @Override
    public Integer[] toArray() {
        Integer[] stringArray = new Integer[integerList.size()];
        for (int i = 0; i < integerList.size(); i++) {
            stringArray[i] = integerList.get(i);
        }
        return stringArray;
    }

    private static Integer[] createArrayRandomInteger() {
        Random r = new Random();
        for (int index = 0; index < random.length; index++) {
            random[index] = r.nextInt();
        }
        return random;
    }

    private static void swap(Integer[] arr, int indexA, int indexB){
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    private static void sortSelection(Integer[] arr) {      // самый быстрый пособ сортировки - 5627 ms
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swap(arr, i, minElementIndex);
        }
    }

    private static boolean contains(Integer[] arr, int element) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        createArrayRandomInteger();
        System.out.println(contains(random, 190885029));
    }
}

/*

Integer[] copyOfArray3 = Arrays.copyOf(random, 100_000);
        long start3 = System.currentTimeMillis();
        sortSelection(copyOfArray3);
        System.out.println("start3 - "+ (System.currentTimeMillis() - start3));

Integer[] copyOfArray1 = Arrays.copyOf(random, 100_000);
        Integer[] copyOfArray2 = Arrays.copyOf(random, 100_000);

        long start1 = System.currentTimeMillis();
        sortBubble(copyOfArray1);
        System.out.println("start1 - " + (System.currentTimeMillis() - start1));

        long start2 = System.currentTimeMillis();
        sortInsertion(copyOfArray2);
        System.out.println("start2 - " + (System.currentTimeMillis() - start2));*/


/*    public static void sortBubble(Integer[] arr){         // самый медленный - 40487 ms
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        swap(arr, j, j + 1);
                    }
                }
            }
        }

    public static void sortInsertion(Integer[] arr) {    // чуть быстрее - 13846 ms
            for (int i = 1; i < arr.length; i++) {
                int temp = arr[i];
                int j = i;
                while (j > 0 && arr[j - 1] >= temp) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                arr[j] = temp;
            }
    }
*/