package com.epam.array.view;

import com.epam.array.util.WrapperArray;

public class ConsoleResultPrinter implements ResultPrinter {
    @Override
    public void printMaxElement(int element) {
        System.out.println("Maximal element: " + element);
    }

    @Override
    public void printMinElement(int element) {
        System.out.println("Minimal element: " + element);
    }

    @Override
    public void printArray(WrapperArray wrapperArray) {
        System.out.println(wrapperArray);
    }
}
