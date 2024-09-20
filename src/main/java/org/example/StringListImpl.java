package org.example;

import java.util.ArrayList;
import java.util.List;

public class StringListImpl implements StringList {
    private List<String> stringList;

    public StringListImpl() {
        stringList = new ArrayList<>(4);
        stringList.add("Белка песенки поёт");
        stringList.add("Да орешки всё грызёт");
        stringList.add("А орешки не простые");
        stringList.add("У них скорлупки золотые");
    }


    @Override
    public String add(String item) {
        stringList.add(item);
        return stringList.get(stringList.indexOf(item));
    }

    @Override
    public String add(int index, String item) {
        if (index > stringList.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        stringList.add(index, item);
        return stringList.get(index);
    }

    @Override
    public String set(int index, String item) {
        if (index > stringList.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        stringList.set(index, item);
        return stringList.get(index);
    }

    @Override
    public String remove(String item) {
        String removed = stringList.get(stringList.indexOf(item));
        stringList.remove(item);
        return removed;
    }

    @Override
    public String remove(int index) {
        String removed = stringList.get(index);
        stringList.remove(index);
        return removed;
    }

    @Override
    public boolean contains(String item) {
        return stringList.contains(item);
    }

    @Override
    public int indexOf(String item) {
        int index = stringList.indexOf(item);
        return index;
    }

    @Override
    public int lastIndexOf(String item) {
        int lastIndex = stringList.lastIndexOf(item);
        return lastIndex;
    }

    @Override
    public String get(int index) {
        String request = stringList.get(index);
        return request;
    }

    @Override
    public boolean equals(StringList otherList) {
        return stringList.equals(otherList);
    }

    @Override
    public int size() {
        return stringList.size();
    }

    @Override
    public boolean isEmpty() {
        return stringList.isEmpty();
    }

    @Override
    public void clear() {
        stringList.clear();
    }

    @Override
    public String[] toArray() {
        String[] stringArray = new String[stringList.size()];
        for (int i = 0; i < stringList.size(); i++) {
            stringArray[i] = stringList.get(i);
        }
        return stringArray;
    }
}
