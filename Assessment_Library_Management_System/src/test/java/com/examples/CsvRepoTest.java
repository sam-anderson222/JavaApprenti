package com.examples;

import com.examples.model.Book;
import com.examples.repository.CsvRepository;
import com.examples.service.LibraryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

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
    public void createsEmptyCatalogOnObjectCreation() {
        LibraryService ls1 = new LibraryService(new CsvRepository("data/csv/libraryData.csv"));

        assertNotNull(ls1.getLibraryCatalog());
    }

    @Test
    public void canAddBook() {
        Book book1 = new Book("Book1", "Author1", 1, "123-4123123");

        // Adding data
        LibraryService ls = new LibraryService(new CsvRepository("data/csv/libraryData.csv"));
        ls.addBook("Fiction-1-1", book1);

        assertEquals(book1, ls.getBook("Fiction-1-1")); // Ensure book was added to catalog.
    }



    @Test
    public void canReloadData() {
        Book book1 = new Book("Book2", "Author2", 1, "123-4123123");

        // Adding data
        LibraryService ls1 = new LibraryService(new CsvRepository("data/csv/libraryData.csv"));
        ls1.addBook("Fiction-1-1", book1);

        LibraryService ls2 = new LibraryService(new CsvRepository("data/csv/libraryData.csv")); // Automatically loads data from file

        assertEquals(1, ls2.getLibraryCatalog().size());
        assertEquals(book1, ls2.getBook("Fiction-1-1"));
    }
}