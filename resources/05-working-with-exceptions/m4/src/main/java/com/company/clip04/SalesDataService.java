package com.company.clip04;

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
        BufferedReader br = null;
        String line = null;
        List<SalesData> list = new ArrayList<>();

        try {
            br = new BufferedReader((new FileReader(path)));
            while ((line = br.readLine()) != null) {

                String[] items = line.split(SEPARATOR);
                SalesData data = new SalesData();

                SimpleDateFormat sdf = new SimpleDateFormat(TIME_PATTERN);
                data.setDate(sdf.parse(items[0]));

                data.setAmount(Double.parseDouble(items[1]));

                list.add(data);
            }

        } catch(ParseException  | IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Finally!");
            try {
                if(br != null) br.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        return list;
    }
}
