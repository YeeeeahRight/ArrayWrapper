package com.epam.array.data.acquirer.impl;

import com.epam.array.data.acquirer.DataAcquirer;
import com.epam.array.data.parser.StringToArrayParser;
import com.epam.array.exceptions.arrays.NullArrayException;
import com.epam.array.exceptions.data.DataTypeException;
import com.epam.array.exceptions.data.InputStreamException;
import com.epam.array.util.WrapperArray;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileDataAcquirer implements DataAcquirer {
    private static final String CLOSE_EXCEPTION_MESSAGE = "Error with closing reader.";
    private static final String FILE_NOT_FOUND_MESSAGE = "File is not found.";
    private static final String INPUT_EXCEPTION_MESSAGE = "Something wrong with your file input.";
    private String fileName;
    private StringToArrayParser parser;

    public FileDataAcquirer(final String fileName, final StringToArrayParser parser) {
        this.fileName = fileName;
        this.parser = parser;
    }

    @Override
    public WrapperArray getWrapperArray() throws DataTypeException, InputStreamException, NullArrayException {
        BufferedReader fileReader = null;
        StringBuilder arrayStr = new StringBuilder();
        try {
            fileReader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = fileReader.readLine()) != null) {
                arrayStr.append(line);
            }
        } catch (FileNotFoundException e) {
            throw new InputStreamException(FILE_NOT_FOUND_MESSAGE);
        } catch (IOException e) {
            throw new InputStreamException(INPUT_EXCEPTION_MESSAGE);
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    System.out.println(CLOSE_EXCEPTION_MESSAGE);
                }
            }
        }
        String resultStr = arrayStr.toString();
        resultStr = deleteNeedlessBytes(resultStr);
        return parser.parse(resultStr);
    }

    private String deleteNeedlessBytes(String strArray) {
        String resultStr = "";
        for (int i = 0; i < strArray.length(); i++) {
            if ((strArray.charAt(i) >= '0'
                    && strArray.charAt(i) <= '9')
                    || strArray.charAt(i) == '-'
                    || strArray.charAt(i) == '+') {
                resultStr = strArray.substring(i);
                break;
            }
        }
        return resultStr;
    }
}
