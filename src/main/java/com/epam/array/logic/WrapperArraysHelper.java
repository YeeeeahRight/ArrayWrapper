package com.epam.array.logic;

import com.epam.array.exceptions.arrays.OutOfBoundsException;
import com.epam.array.util.WrapperArray;

public class WrapperArraysHelper implements ArraysHelper {

    @Override
    public void sortArray(WrapperArray array) throws OutOfBoundsException {
        insertionSort(array);
    }

    private void insertionSort(WrapperArray array) throws OutOfBoundsException {
        int size = array.getSize();
        for (int i = 1; i < size; i++) {
            int key = array.get(i);
            int j = i - 1;
            while (j >= 0 && array.get(j) > key) {
                array.set(j + 1, array.get(j));
                j = j - 1;
            }
            array.set(j + 1, key);
        }
    }

    @Override
    public int findMaxElement(WrapperArray array) throws OutOfBoundsException {
        int size = array.getSize();
        int maxElement = array.get(size - 1);
        for (int i = size - 2; i > 0; i--) {
            if (array.get(i) > maxElement) {
                maxElement = array.get(i);
            }
        }
        return maxElement;
    }

    @Override
    public int findMinElement(WrapperArray array) throws OutOfBoundsException {
        int size = array.getSize();
        int minElement = array.get(0);
        for (int i = 1; i < size; i++) {
            if (array.get(i) < minElement) {
                minElement = array.get(i);
            }
        }
        return minElement;
    }
}
