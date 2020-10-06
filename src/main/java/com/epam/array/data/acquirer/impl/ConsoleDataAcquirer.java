package com.epam.array.data.acquirer.impl;

import com.epam.array.data.acquirer.DataAcquirer;
import com.epam.array.data.parser.StringToArrayParser;
import com.epam.array.exceptions.arrays.NullArrayException;
import com.epam.array.exceptions.data.DataTypeException;
import com.epam.array.exceptions.data.InputStreamException;
import com.epam.array.util.WrapperArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleDataAcquirer implements DataAcquirer {
    private static final String INPUT_EXCEPTION_MESSAGE = "Something wrong with your input.";
    private static final String CLOSE_EXCEPTION_MESSAGE = "Error with closing reader.";
    private static final String ENTER_ELEMENTS_MESSAGE = "Enter elements of the array: ";
    private StringToArrayParser parser;

    public ConsoleDataAcquirer(final StringToArrayParser parser) {
        this.parser = parser;
    }

    @Override
    public WrapperArray getWrapperArray() throws DataTypeException, InputStreamException, NullArrayException {
        BufferedReader reader = null;
        String arrayStr;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print(ENTER_ELEMENTS_MESSAGE);
            arrayStr = reader.readLine();
        } catch (IOException e) {
            throw new InputStreamException(INPUT_EXCEPTION_MESSAGE);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println(CLOSE_EXCEPTION_MESSAGE);
                }
            }
        }
        return parser.parse(arrayStr);
    }
}
