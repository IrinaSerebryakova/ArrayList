package org.example;

import org.example.exception.StringAlreadyExist;
import org.example.exception.StringArrayIndexOutOfBoundsException;
import org.example.exception.StringNullPointerException;

import java.util.ArrayList;
import java.util.List;

public class StringListImpl implements StringList {
    private List<String> stringList;
    int counter = 0;
    public StringListImpl() {
        stringList = new ArrayList<>(4);
    }

    public boolean checkItemNotNull(String item){
        if (!item.equals(null)) {
            return true;
        }else {
            throw new StringNullPointerException("Строка не может быть null!");
        }
    }

    public boolean checkIndexNoLessNullOrMoreThanSizeOfList(int index) {
        if (!(index > stringList.size()) || !(index < 0)) {
           return true;
        }else {
            throw new StringArrayIndexOutOfBoundsException("Индекс строки выходит за пределы динамического массива!");
        }
    }

    public boolean checkStringAlreadyExist(String item){
        if (stringList.contains(item)){
            throw new StringAlreadyExist("Данная строка уже существует!");
        }
        return true;
    }

    public int counter(){
        for (String str : stringList) {
            if (!str.equals(null)) {
                counter++;
            }
        }
        return counter;
    }

    public void toMoreVolumeArrayList(){
        ArrayList<String> secondList = new ArrayList<>(stringList.size() * 3 / 2 + 1);
        for (String str : stringList) {
            secondList.add(str);
        }
        stringList = new ArrayList<>(secondList);
    }

    @Override
    public String add(String item) {
        if (checkItemNotNull(item) && checkStringAlreadyExist(item)) {
            counter();
            if (counter == stringList.size()) {
                toMoreVolumeArrayList();
            }
            stringList.add(item);
        }
        return stringList.get(stringList.indexOf(item));
    }

    @Override
    public String add(int index, String item) {
        if (checkItemNotNull(item) && checkStringAlreadyExist(item)) {
            if (checkIndexNoLessNullOrMoreThanSizeOfList(index)) {
                counter();
                if (counter == stringList.size()) {
                    toMoreVolumeArrayList();
                    }
                stringList.add(index, item);
            }
        }
        return stringList.get(index);
    }

    @Override
    public String set(int index, String item) {
        if (checkItemNotNull(item) && checkStringAlreadyExist(item)) {
            if (checkIndexNoLessNullOrMoreThanSizeOfList(index)) {
                counter();
                try {
                    if (counter == stringList.size()) {
                        toMoreVolumeArrayList();
                        stringList.set(index, item);
                    }
                }
                catch(IndexOutOfBoundsException e){
                }
            }
        }
        return stringList.get(index);
    }

    @Override
    public String remove(String item) {
        String removed = null;
        if (checkItemNotNull(item)) {
            removed = stringList.get(stringList.indexOf(item));
            stringList.remove(item);
        }
        return removed;
    }

    @Override
    public String remove(int index) {
        String removed = null;
        if (checkIndexNoLessNullOrMoreThanSizeOfList(index)) {
            removed = stringList.get(index);
            stringList.remove(index);
        }
        return removed;
    }

    @Override
    public boolean contains(String item) {
       return stringList.contains(item);
    }

    @Override
    public int indexOf(String item) {
        int index = -1;
        if (checkItemNotNull(item)) {
            index = stringList.indexOf(item);
        }
        return index;
    }

    @Override
    public int lastIndexOf(String item) {
        int lastIndex = -1;
        if (checkItemNotNull(item)) {
            lastIndex = stringList.lastIndexOf(item);
        }
        return lastIndex;
    }

    @Override
    public String get(int index) {
        String request = null;
        if (checkIndexNoLessNullOrMoreThanSizeOfList(index)) {
            request = stringList.get(index);
        }
        return request;
    }

    @Override
    public boolean equals(StringList otherList) {
        return stringList.equals(otherList);
    }

    @Override
    public int size() {
        if (stringList == null) {
            throw new NullPointerException();
        }
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
