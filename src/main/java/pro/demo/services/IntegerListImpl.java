package pro.demo.services;

import org.springframework.stereotype.Service;
import pro.demo.Exceptions.ElementNotFound;
import pro.demo.Exceptions.IndexOutOfRange;
import pro.demo.Exceptions.NullPointerException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;


@Service
public class IntegerListImpl implements IntegerList {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 100000;
    private Object[] elements;
    public IntegerListImpl() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    public IntegerListImpl(Collection<Integer> c) {
        if (c.size() > 0) {
            elements = c.toArray();
            size = elements.length;
        }
    }

    @Override
    public Integer add(Integer item) {
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
    public Integer add(int index, Integer item) {
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
    public Integer set (int index, Integer item) {
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
    public  Integer remove (Integer item) {
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
    public  Integer removeByIndex (int index) {

        if (index < size) {
            Integer temp = (Integer) elements[index];
            for (int i = index; i < size; i++) {
                elements[i] = elements[i + 1];
            }
            size--;
            return temp;
        } else {
            throw new IndexOutOfRange();
        }
    }

//    @Override
//    public boolean contains(Integer item) {
//        boolean switcher = false;
//        for (int i = 0; i < size; i++) {
//            if (elements[i] == item) {
//                switcher = true;
//                break;
//            }
//        }
//        return switcher;
//    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {

        for (int i = size - 1; i >= 0; i--) {
            if (elements[i] == item) {
                return size - i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        if (index < size) {
            return (Integer) elements[index];
        } else {
            throw new IndexOutOfRange();
        }
    }

    @Override
    public boolean equals(IntegerListImpl otherList) {
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
    public Integer[] toArray() {
        Integer[] Integer_list = new Integer[size];
        for (int i = 0; i < size; i++) {
            Integer_list[i] = (Integer) elements[i];
        }
        return Integer_list;
    }
    public void sortBubble() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if ((Integer) elements[j] > (Integer) elements[j + 1]) {
                    swapElements(elements, j, j + 1);
                }
            }
        }
        System.out.println(System.currentTimeMillis() - start);
    }
    public void sortSelection() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < size; j++) {
                if ((Integer)elements[j] < (Integer)elements[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(elements, i, minElementIndex);
        }
        System.out.println(System.currentTimeMillis() - start);
    }
    public void sortInsertion() {
        long start = System.currentTimeMillis();
        for (int i = 1; i < size; i++) {
            int temp = (Integer) elements[i];
            int j = i;
            while (j > 0 && (Integer) elements[j - 1] >= temp) {
                elements[j] = elements[j - 1];
                j--;
            }
            elements[j] = temp;
        }
        System.out.println(System.currentTimeMillis() - start);
    }
    @Override
    public boolean contains(Integer item) {
        long start = System.currentTimeMillis();
        int min = 0;
        int max = size - 1;
        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == elements[mid]) {
                System.out.println(System.currentTimeMillis() - start);
                return true;
            }
            if (item < (Integer) elements[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(System.currentTimeMillis() - start);
        return false;
    }

    private static void swapElements(Object[] arr, Integer indexA, Integer indexB) {
        int tmp = (Integer)arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
    @Override
    public void randomArrays() {
        Random rd = new Random();
        for (size = 0; size < DEFAULT_CAPACITY; size++) {
            elements[size] = rd.nextInt();
        }
    }
}
