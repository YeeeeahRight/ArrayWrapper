package com.epam.array.data.acquirer;

import com.epam.array.exceptions.arrays.NullArrayException;
import com.epam.array.exceptions.data.DataTypeException;
import com.epam.array.exceptions.data.InputStreamException;
import com.epam.array.util.WrapperArray;

public interface DataAcquirer {
    WrapperArray getWrapperArray() throws DataTypeException, InputStreamException, NullArrayException;
}
