package com.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.examples.model.Book;
import com.examples.repository.CsvRepository;
import com.examples.service.LibraryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.io.File;

/**
 * Unit test for simple App.
 */
public class CsvRepoTest {
    /**
     * Rigorous Test :-)
     */
    @BeforeEach
    public void setUp() {
        File file = new File("data/csv/libraryData.csv");
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void canReloadData() {
        LibraryService ls1 = new LibraryService(new CsvRepository("data/csv/libraryData.csv"));
        ls1.addBook("Fiction-1-1", new Book("RToC", "Tremendous", 1, "123-4123123"));

        LibraryService ls2 = new LibraryService(new CsvRepository("data/csv/libraryData.csv")); // Automatically loads data from file

        assertEquals(1, ls2.getLibraryCatalog().size());
    }
}