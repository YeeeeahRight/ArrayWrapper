package com.epam.array.main;

import com.epam.array.data.DataAcquirer;
import com.epam.array.data.DataAcquirerFactory;
import com.epam.array.enums.InputWayEnum;
import com.epam.array.exceptions.arrays.NullArrayException;
import com.epam.array.exceptions.arrays.OutOfBoundsException;
import com.epam.array.exceptions.data.DataTypeException;
import com.epam.array.exceptions.data.InputStreamException;
import com.epam.array.exceptions.data.UnknownInputWayException;
import com.epam.array.util.WrapperArray;
import com.epam.array.util.WrapperArraysHelper;
import com.epam.array.view.ConsoleResultPrinter;
import com.epam.array.view.ResultPrinter;

public class Main {
    public static void main(String[] args) throws UnknownInputWayException, DataTypeException,
            InputStreamException, NullArrayException, OutOfBoundsException {
        DataAcquirerFactory dataCreator = new DataAcquirerFactory();
        InputWayEnum inputWay = InputWayEnum.CONSOLE;
        DataAcquirer dataAcquirer = dataCreator.createDataAcquirer(inputWay);
        int[] array = dataAcquirer.getArray();
        WrapperArray wrapperArray = new WrapperArray(array);
        WrapperArraysHelper arraysHelper = new WrapperArraysHelper();
        //view
        ResultPrinter resultPrinter = new ConsoleResultPrinter();
        int maxElement = arraysHelper.findMaxElement(wrapperArray);
        int minElement = arraysHelper.findMinElement(wrapperArray);
        resultPrinter.printMaxElement(maxElement);
        resultPrinter.printMinElement(minElement);
        //before sort
        resultPrinter.printArray(wrapperArray);
        arraysHelper.sortArray(wrapperArray);
        //after sort
        resultPrinter.printArray(wrapperArray);
    }
}
