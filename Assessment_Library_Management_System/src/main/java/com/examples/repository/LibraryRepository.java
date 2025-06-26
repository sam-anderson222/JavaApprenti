package com.examples.repository;

import java.lang.reflect.Array;
import com.examples.model.Result;
import java.util.ArrayList;
import java.util.HashMap;
import com.examples.model.Book;

public interface LibraryRepository {

    // File IO functions
    void load();
    void save();

    // Library service functions (BookIdentifier is Genre-ShelfNo-PositionNo)
    HashMap<String, Book> getLibraryCatalog();
    Book getBook(String bookIdentifier);
    ArrayList<Book> findByCategory(String category);
    Result<String> addBook(String bookIdentifier, Book book); // bookID is the key of the catalog hashMap
    boolean updateBook(String bookIdentifier, Book book);
    boolean deleteBook(String bookIdentifier);

}
