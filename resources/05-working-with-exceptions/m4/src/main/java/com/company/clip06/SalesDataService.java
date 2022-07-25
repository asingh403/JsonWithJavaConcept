package com.company.clip06;

import com.company.common.SalesData;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SalesDataService {
    private static final String SEPARATOR = "\\|";
    private static final String TIME_PATTERN = "HH:mm";

    public List<SalesData> processData(String path) {
        String line = null;
        List<SalesData> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader((new FileReader(path)))) {
            while ((line = br.readLine()) != null) {

                String[] items = line.split(SEPARATOR);
                SalesData data = new SalesData();

                SimpleDateFormat sdf = new SimpleDateFormat(TIME_PATTERN);
                data.setDate(sdf.parse(items[0]));

                data.setAmount(Double.parseDouble(items[1]));

                list.add(data);
            }
        } catch(ParseException  | IOException e) {
            //e.printStackTrace();
            ArithmeticException ae = new ArithmeticException();
            ae.initCause(e);
            throw ae;
        }

        return list;
    }
}
