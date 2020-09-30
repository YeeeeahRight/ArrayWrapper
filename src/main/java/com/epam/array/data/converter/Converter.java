package com.epam.array.data.converter;

import java.util.ArrayList;

public class Converter implements Convertible {
    @Override
    public int[] convertToPrimitiveArray(ArrayList<Integer> arrayList) {
        int[] array = new int[arrayList.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = arrayList.get(i);
        }
        return array;
    }
}
