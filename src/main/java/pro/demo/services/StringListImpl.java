package pro.demo.services;

import org.springframework.stereotype.Service;
import pro.demo.Exceptions.ElementNotFound;
import pro.demo.Exceptions.IndexOutOfRange;
import pro.demo.Exceptions.NullPointerException;

import java.util.Arrays;
import java.util.Collection;



@Service
public class StringListImpl implements StringList {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    public StringListImpl() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    public StringListImpl(Collection<String> c) {
        if (c.size() > 0) {
            elements = c.toArray();
            size = elements.length;
        }
    }

    @Override
    public String add(String item) {
        if (size == elements.length) {
            ensureCapa();
        }
        if (item == null) {
            throw new NullPointerException();
        }
        elements[size++] = item;
        return item;
    }
    @Override
    public String add(int index, String item) {
        if (size == elements.length) {
            ensureCapa();
        }
        if (item == null) {
            throw new NullPointerException();
        } else if (index < size) {
            ++size;
            for (int i = size - 1; index <= i; i--) {
                elements[i] = elements[i - 1];

            }
            elements[index] = item;

            return item;
        } else {
            throw new IndexOutOfRange();
        }

    }
    @Override
    public String set (int index, String item) {
        if (item == null) {
            throw new NullPointerException();
        } else if (index < size) {
            elements[index] = item;
            return item;
        } else {
            throw new IndexOutOfRange();
        }
    }
    @Override
    public  String remove (String item) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == item) {
                for (;i < size; i++) {
                    elements[i] = elements[i + 1];
                }
                size--;
                return item;
            }
        }
        throw new ElementNotFound();
    }
    @Override
    public  String remove (int index) {

        if (index < size) {
            String temp = elements[index].toString();
            for (int i = index; i < size; i++) {
                elements[i] = elements[i + 1];
            }
            size--;
            return temp;
        } else {
            throw new IndexOutOfRange();
        }
    }

    @Override
    public boolean contains(String item) {
        boolean switcher = false;
        for (int i = 0; i < size; i++) {
            if (elements[i] == item) {
                switcher = true;
                break;
            }
        }
        return switcher;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {

        for (int i = size - 1; i >= 0; i--) {
            if (elements[i] == item) {
                return size - i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index < size) {
            return elements[index].toString();
        } else {
            throw new IndexOutOfRange();
        }
    }

    @Override
    public boolean equals(StringListImpl otherList) {
        if (otherList.isEmpty()) {
            throw new NullPointerException();
        }
        if (otherList.size() != size){
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (otherList.get(i) == null) {
                throw new NullPointerException();
            }
            boolean switcher = otherList.get(i) == elements[i];
            if (!switcher) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] string_list = new String[size];
        for (int i = 0; i < size; i++) {
            string_list[i] = elements[i].toString();
        }
        return string_list;
    }


    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

}
