package com.examples;

import com.examples.repository.CsvRepository;
import com.examples.repository.LibraryRepository;
import com.examples.service.LibraryService;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService(new CsvRepository("data/csv/libraryData.csv"));


    }
}
