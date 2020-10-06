package com.epam.array.data.factory.impl;

import com.epam.array.data.acquirer.DataAcquirer;
import com.epam.array.data.acquirer.impl.RandomDataAcquirer;
import com.epam.array.data.factory.DataAcquirerFactory;

public class RandomDataAcquirerFactory implements DataAcquirerFactory {
    private static final int SIZE = 10;

    @Override
    public DataAcquirer createDataAcquirer() {
        return new RandomDataAcquirer(SIZE);
    }
}
