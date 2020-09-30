package com.epam.array.data;

import com.epam.array.exceptions.data.DataTypeException;
import com.epam.array.exceptions.data.InputStreamException;

public interface DataAcquirer {
    int[] getArray() throws DataTypeException, InputStreamException;
}
