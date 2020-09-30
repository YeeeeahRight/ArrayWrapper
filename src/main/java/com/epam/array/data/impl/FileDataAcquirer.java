package com.epam.array.data.impl;

import com.epam.array.data.DataAcquirer;
import com.epam.array.data.converter.Converter;
import com.epam.array.exceptions.data.DataTypeException;
import com.epam.array.exceptions.data.InputStreamException;

import java.io.*;
import java.util.ArrayList;

public class FileDataAcquirer implements DataAcquirer {
    private final static String FILE_TXT = "text.txt";
    private final static String CLOSE_EXCEPTION_MESSAGE = "Error with closing reader.";
    private final static String FILE_NOT_FOUND_MESSAGE = "File is not found.";
    private final static String INCORRECT_DATA_TYPE_MESSAGE = "Incorrect data type in file.";
    private final static String INPUT_EXCEPTION_MESSAGE = "Something wrong with your file input.";

    @Override
    public int[] getArray() throws DataTypeException, InputStreamException {
        BufferedReader fileReader = null;
        ArrayList<Integer> arrayList = new ArrayList<>();
        try {
            fileReader = new BufferedReader(new FileReader(FILE_TXT));
            inputListFile(arrayList, fileReader);
        } catch (NumberFormatException e) {
            throw new DataTypeException(INCORRECT_DATA_TYPE_MESSAGE);
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
        Converter converter = new Converter();
        return converter.convertToPrimitiveArray(arrayList);
    }

    private void inputListFile(ArrayList<Integer> arrayList, BufferedReader fileReader) throws IOException {
        String inputStr;
        while ((inputStr = fileReader.readLine()) != null) {
            System.out.println(inputStr);
            Integer.parseInt(inputStr);
        }
    }
}
