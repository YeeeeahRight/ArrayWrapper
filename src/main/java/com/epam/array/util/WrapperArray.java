package com.epam.array.util;

import com.epam.array.exceptions.arrays.IncorrectCapacityException;
import com.epam.array.exceptions.arrays.NullArrayException;
import com.epam.array.exceptions.arrays.OutOfBoundsException;

public class WrapperArray {
    private static final int DEFAULT_CAPACITY = 10;
    private static final String INCORRECT_CAPACITY_MESSAGE = "Incorrect capacity of the array.";
    private static final String NULL_ARRAY_MESSAGE = "Null array.";
    private static final String OUT_OF_BOUNDS_MESSAGE = "Out of bounds of an array.";
    private int[] array;
    private int size;

    public WrapperArray() {
        this.array = new int[DEFAULT_CAPACITY];
        this.size = DEFAULT_CAPACITY;
    }

    public WrapperArray(int capacity) throws IncorrectCapacityException {
        if (capacity < 0) {
            throw new IncorrectCapacityException(INCORRECT_CAPACITY_MESSAGE);
        }
        if (capacity > 0) {
            this.array = new int[capacity];
            this.size = capacity;
        } else {
            this.array = new int[0];
        }
    }

    public WrapperArray(int[] array) throws NullArrayException {
        if (array == null) {
            throw new NullArrayException(NULL_ARRAY_MESSAGE);
        }
        this.array = array;
        this.size = array.length;
    }

    public int get(int index) throws OutOfBoundsException {
        this.checkIndex(index);
        return array[index];
    }

    public void set(int index, int number) throws OutOfBoundsException {
        this.checkIndex(index);
        this.array[index] = number;
    }

    private void checkIndex(int index) throws OutOfBoundsException {
        if (index < 0 || index >= this.size) {
            throw new OutOfBoundsException(OUT_OF_BOUNDS_MESSAGE);
        }
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public int hashCode() {
        if (this.array == null) {
            return 0;
        } else {
            int result = 1;
            int[] secondArray = this.array;
            for (int i = 0; i < this.array.length; i++) {
                int element = secondArray[i];
                result = 31 * result + element;
            }
            return result;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof WrapperArray)) {
            return false;
        }
        WrapperArray secondWrapperArray = (WrapperArray) o;
        if (this.getSize() != secondWrapperArray.getSize()) {
            return false;
        }
        return this.equalsContentArrays(this.array, secondWrapperArray.array);
    }

    @Override
    public String toString() {
        if (this.array == null) {
            return "null";
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("WrapperArray{array = [ ");
            int size = this.size;
            if (size == 0) {
                stringBuilder.append(']');
            } else {
                int index = 0;
                while (index != size) {
                    stringBuilder.append(this.array[index++]);
                    stringBuilder.append(' ');
                }
            }
            stringBuilder.append("], size = ");
            stringBuilder.append(this.size);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    private boolean equalsContentArrays(int[] firstArray, int[] secondArray) {
        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] != secondArray[i]) {
                return false;
            }
        }
        return true;
    }
}
