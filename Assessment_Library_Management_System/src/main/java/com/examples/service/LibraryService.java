package com.examples.service;

import com.examples.repository.LibraryRepository;
import com.examples.model.Book;

import java.util.HashMap;

public class LibraryService {
    private LibraryRepository repository;

    public LibraryService (LibraryRepository repository) {
        this.repository = repository;
    }

    public boolean addBook(String bookIdentifier, Book book) {
        return repository.addBook(bookIdentifier, book);
    }

    public HashMap<String, Book> getLibraryCatalog() {
        return repository.getLibraryCatalog();
    }

}
