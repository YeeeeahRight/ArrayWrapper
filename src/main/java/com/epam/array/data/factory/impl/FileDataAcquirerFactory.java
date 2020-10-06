package com.epam.array.data.factory.impl;

import com.epam.array.data.acquirer.DataAcquirer;
import com.epam.array.data.acquirer.impl.FileDataAcquirer;
import com.epam.array.data.factory.DataAcquirerFactory;
import com.epam.array.data.parser.StringToArrayParser;

public class FileDataAcquirerFactory implements DataAcquirerFactory {
    private static final String FILE_NAME = "text.txt";
    private static final StringToArrayParser PARSER = new StringToArrayParser();

    @Override
    public DataAcquirer createDataAcquirer() {
        return new FileDataAcquirer(FILE_NAME, PARSER);
    }
}
