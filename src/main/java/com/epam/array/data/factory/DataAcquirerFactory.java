package com.epam.array.data.factory;

import com.epam.array.data.acquirer.DataAcquirer;

public interface DataAcquirerFactory {
    DataAcquirer createDataAcquirer();
}
