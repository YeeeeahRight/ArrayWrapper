package com.epam.array.data.impl;

import com.epam.array.data.DataAcquirer;
import com.epam.array.data.converter.Converter;
import com.epam.array.exceptions.data.DataTypeException;
import com.epam.array.exceptions.data.InputStreamException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ConsoleDataAcquirer implements DataAcquirer {
    private final static String INCORRECT_DATA_TYPE_MESSAGE = "Incorrect data type of element(element should be a number).";
    private final static String INPUT_EXCEPTION_MESSAGE = "Something wrong with your input.";
    private final static String CLOSE_EXCEPTION_MESSAGE = "Error with closing reader.";
    private final static String STOP_WORD = "STOP";

    @Override
    public int[] getArray() throws DataTypeException, InputStreamException {
        System.out.println("Enter '" + STOP_WORD + "' to stop entering array");
        ArrayList<Integer> arrayList = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            inputListConsole(arrayList, reader);
        } catch (NumberFormatException e) {
            throw new DataTypeException(INCORRECT_DATA_TYPE_MESSAGE);
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
        Converter converter = new Converter();
        return converter.convertToPrimitiveArray(arrayList);
    }

    private void inputListConsole(ArrayList<Integer> arrayList, BufferedReader reader)
            throws IOException, NumberFormatException {
        boolean isStop = false;
        String strInput;
        int index = 1;
        while (!isStop) {
            System.out.printf("Enter array[%d]: ", index++);
            strInput = reader.readLine();
            if (STOP_WORD.equals(strInput)) {
                isStop = true;
            } else {
                arrayList.add(Integer.parseInt(strInput));
            }
        }
    }
}
