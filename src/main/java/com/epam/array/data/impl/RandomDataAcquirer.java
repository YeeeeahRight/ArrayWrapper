package com.epam.array.data.impl;

import com.epam.array.data.DataAcquirer;

public class RandomDataAcquirer implements DataAcquirer {
    @Override
    public int[] getArray() {
        int size = (int)(Math.random() * 25 + 1);
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int)(Math.random() * 401) - 200;
        }
        return array;
    }
}
