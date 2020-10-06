package com.epam.array.view;

import com.epam.array.util.WrapperArray;

public class ConsoleResultPrinter implements ResultPrinter {
    private static final String MAX_ELEMENT_MESSAGE = "Maximal element: ";
    private static final String MIN_ELEMENT_MESSAGE = "Minimal element: ";

    @Override
    public void printMaxElement(int element) {
        System.out.println(MAX_ELEMENT_MESSAGE + element);
    }

    @Override
    public void printMinElement(int element) {
        System.out.println(MIN_ELEMENT_MESSAGE + element);
    }

    @Override
    public void printArray(WrapperArray wrapperArray) {
        System.out.println(wrapperArray);
    }
}
