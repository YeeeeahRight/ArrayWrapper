package com.epam.array.data;

import com.epam.array.data.impl.ConsoleDataAcquirer;
import com.epam.array.data.impl.FileDataAcquirer;
import com.epam.array.data.impl.RandomDataAcquirer;
import com.epam.array.enums.InputWayEnum;
import com.epam.array.exceptions.data.UnknownInputWayException;

public class DataAcquirerFactory {
    private static final String UNKNOWN_INPUT_WAY_MESSAGE = "Unknown input way.";

    public DataAcquirer createDataAcquirer(InputWayEnum way) throws UnknownInputWayException {
        switch (way) {
            case CONSOLE:
                return new ConsoleDataAcquirer();
            case FILE:
                return new FileDataAcquirer();
            case RANDOM:
                return new RandomDataAcquirer();
            default:
                throw new UnknownInputWayException(UNKNOWN_INPUT_WAY_MESSAGE);
        }
    }
}
