package com.epam.array.data.parser;

import com.epam.array.exceptions.arrays.NullArrayException;
import com.epam.array.exceptions.data.DataTypeException;

public interface Parsable<S, R> {
    R parse(S source) throws DataTypeException, NullArrayException;
}
