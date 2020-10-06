package com.epam.array.data.parser;

import com.epam.array.exceptions.arrays.NullArrayException;
import com.epam.array.exceptions.data.DataTypeException;
import com.epam.array.util.WrapperArray;

public class StringToArrayParser implements Parsable<String, WrapperArray> {

    private static final String SPLITERATOR = "\\s";
    private static final String NUMBER_PATTERN = "[-+]?\\d+";
    private static final String INCORRECT_DATA_TYPE_MESSAGE = "Incorrect data type of elements.";

    public WrapperArray parse(String line) throws DataTypeException, NullArrayException {
        String[] lines = line.split(SPLITERATOR);
        int[] numbers = new int[lines.length];
        for (int i = 0; i < lines.length; i++) {
            if (!lines[i].matches(NUMBER_PATTERN)) {
                throw new DataTypeException(INCORRECT_DATA_TYPE_MESSAGE);
            }
            numbers[i] = Integer.parseInt(lines[i]);
        }
        return new WrapperArray(numbers);
    }
}
