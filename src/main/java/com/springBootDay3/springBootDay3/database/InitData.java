package com.springBootDay3.springBootDay3.database;

import com.springBootDay3.springBootDay3.utils.CSVFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// @Configuration
@Component
public class InitData implements CommandLineRunner {
    @Autowired
    private CSVFileReader csvFileReader;

    @Override
    public void run(String... args) throws Exception {
        PersonDB.persons = csvFileReader.readFile("person.csv");
    }
}
