package com.epam.array.data.acquirer.impl;

import com.epam.array.data.acquirer.DataAcquirer;
import com.epam.array.exceptions.arrays.NullArrayException;
import com.epam.array.util.WrapperArray;

public class RandomDataAcquirer implements DataAcquirer {
    private int size;

    public RandomDataAcquirer(final int size) {
        this.size = size;
    }

    @Override
    public WrapperArray getWrapperArray() throws NullArrayException {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int)(Math.random() * 401) - 200;
        }
        return new WrapperArray(array);
    }
}
