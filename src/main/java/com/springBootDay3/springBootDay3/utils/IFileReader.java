package com.springBootDay3.springBootDay3.utils;

import com.springBootDay3.springBootDay3.model.Person;

import java.util.List;

public interface IFileReader {
    List<Person> readFile(String filePath);
}
