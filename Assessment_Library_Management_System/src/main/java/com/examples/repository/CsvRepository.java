package com.examples.repository;

import com.examples.model.Book;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class CsvRepository implements LibraryRepository {
    HashMap<String, Book> libraryCatalog;
    private final String filePath;

    public CsvRepository(String filePath) {
        libraryCatalog = new HashMap<>();
        this.filePath = filePath;
        load();
    }

    // Csv Data looks like Category-ShelfNo-PosNo,bookTitle-bookAuthor-bookYear-ISBN, Category-ShelfNo-PosNo is the key.
    @Override
    public void load() {
        File file = new File(filePath);

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String dataEntry;

                while ((dataEntry = reader.readLine()) != null) {
                    // data[0] is the key, while data[1] must be split to get all the fields of the book.
                    String[] libraryCatalogEntry = dataEntry.split(",");

                    // [0] = title, [1] = author, [2] = (int) year, [3] = ISBN
                    String[] bookData = libraryCatalogEntry[1].split("~");
                    libraryCatalog.put(libraryCatalogEntry[0], new Book(bookData[0], bookData[1], Integer.parseInt(bookData[2]), bookData[3]));
                }
            } catch (Exception ex) {
                System.out.println("Error when loading file");
            }
;        }
    }

    @Override
    public void save() {
        File file = new File(filePath);

        // Delete file if there is no data to store.
        if (libraryCatalog.isEmpty() && file.exists()) {
            file.delete();
            return;
        }

        // If we have data, let's overwrite the file.
        if (!libraryCatalog.isEmpty()) {
            try (PrintWriter writer = new PrintWriter(file)) { // Creates file if there is none.
                for (String key: libraryCatalog.keySet()) {
                    Book b = libraryCatalog.get(key); // Getting book object
                    writer.printf("%s,%s~%s~%s~%s%n", key, b.title(), b.author(), b.year(), b.ISBN());
                }
            } catch (Exception ex) {
                System.out.println("Error with saving file");
            }
        }
    }

    @Override
    public ArrayList<Book> findByCategory(String category) {
        return null;
    }

    @Override
    public boolean addBook(String bookIdentifier, Book book) {
        libraryCatalog.put(bookIdentifier, book);
        save();
        return true;
    }

    @Override
    public boolean updateBook(String bookIdentifier, Book book) {
        return false;
    }

    @Override
    public boolean deleteBook(String bookIdentifier) {
        return false;
    }

    @Override
    public HashMap<String, Book> getLibraryCatalog() {
        return libraryCatalog;
    }
}
