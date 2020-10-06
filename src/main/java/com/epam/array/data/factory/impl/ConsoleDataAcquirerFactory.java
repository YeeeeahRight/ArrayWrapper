package com.epam.array.data.factory.impl;

import com.epam.array.data.acquirer.impl.ConsoleDataAcquirer;
import com.epam.array.data.acquirer.DataAcquirer;
import com.epam.array.data.factory.DataAcquirerFactory;
import com.epam.array.data.parser.StringToArrayParser;

public class ConsoleDataAcquirerFactory implements DataAcquirerFactory {
    private static final StringToArrayParser PARSER = new StringToArrayParser();

    @Override
    public DataAcquirer createDataAcquirer() {
        return new ConsoleDataAcquirer(PARSER);
    }
}
