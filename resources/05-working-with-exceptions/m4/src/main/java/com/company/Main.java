package com.company;


import com.company.clip04.SalesDataService;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        SalesDataService service = new SalesDataService();
        List list = service.processData("c:\\file.txt");
        System.out.println(list);
    }
}