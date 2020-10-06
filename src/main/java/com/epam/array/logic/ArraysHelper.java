package com.epam.array.logic;

import com.epam.array.exceptions.arrays.OutOfBoundsException;
import com.epam.array.util.WrapperArray;

public interface ArraysHelper {
    void sortArray(WrapperArray array) throws OutOfBoundsException;
    int findMaxElement(WrapperArray array) throws OutOfBoundsException;
    int findMinElement(WrapperArray array) throws OutOfBoundsException;
}
