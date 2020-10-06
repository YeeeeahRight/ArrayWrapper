package com.epam.array.main;

import com.epam.array.data.acquirer.DataAcquirer;
import com.epam.array.data.factory.DataAcquirerFactory;
import com.epam.array.data.factory.impl.FileDataAcquirerFactory;
import com.epam.array.exceptions.arrays.NullArrayException;
import com.epam.array.exceptions.arrays.OutOfBoundsException;
import com.epam.array.exceptions.data.DataTypeException;
import com.epam.array.exceptions.data.InputStreamException;
import com.epam.array.util.WrapperArray;
import com.epam.array.logic.WrapperArraysHelper;
import com.epam.array.view.ConsoleResultPrinter;
import com.epam.array.view.ResultPrinter;

public class Main {
    public static void main(String[] args) throws DataTypeException,
            InputStreamException, NullArrayException, OutOfBoundsException {
        DataAcquirerFactory dataCreator = new FileDataAcquirerFactory();
        DataAcquirer dataAcquirer = dataCreator.createDataAcquirer();
        WrapperArray wrapperArray = dataAcquirer.getWrapperArray();
        WrapperArraysHelper arraysHelper = new WrapperArraysHelper();
        ResultPrinter resultPrinter = new ConsoleResultPrinter();
        //calculate
        int maxElement = arraysHelper.findMaxElement(wrapperArray);
        int minElement = arraysHelper.findMinElement(wrapperArray);
        //view calculations
        resultPrinter.printMaxElement(maxElement);
        resultPrinter.printMinElement(minElement);
        //print array before sort
        resultPrinter.printArray(wrapperArray);
        //sort array
        arraysHelper.sortArray(wrapperArray);
        //print array after sort
        resultPrinter.printArray(wrapperArray);
    }
}
