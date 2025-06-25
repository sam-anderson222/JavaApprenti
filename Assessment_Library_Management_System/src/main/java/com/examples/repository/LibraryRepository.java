package com.examples.repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import com.examples.model.Book;

public interface LibraryRepository {

    // File IO functions
    void load();
    void save(HashMap<String, Book> catalog);

    // Library service functions
    ArrayList<Book> findByCategory(String category);
    boolean addBook(String bookIdentifier, Book book); // bookID is the key of the catalog hashMap
    boolean updateBook(String bookIdentifier, Book book);
    boolean deleteBook(String bookIdentifier);

}
