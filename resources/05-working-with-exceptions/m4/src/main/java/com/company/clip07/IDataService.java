package com.company.clip07;

import com.company.common.SalesData;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public interface IDataService {
    List<SalesData> processData(String path) throws ParseException, IOException;
}
