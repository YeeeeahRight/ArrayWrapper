package com.epam.array.util;

import com.epam.array.exceptions.arrays.OutOfBoundsException;

public interface ArraysHelper {
    void sortArray(WrapperArray array) throws OutOfBoundsException;
    int findMaxElement(WrapperArray array) throws OutOfBoundsException;
    int findMinElement(WrapperArray array) throws OutOfBoundsException;
}
