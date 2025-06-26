package com.examples.service;

import com.examples.model.Result;
import com.examples.repository.LibraryRepository;
import com.examples.model.Book;

import java.util.HashMap;

public class LibraryService {
    private final LibraryRepository repository;

    public LibraryService (LibraryRepository repository) {
        this.repository = repository;
    }


    public Result<String> addBook(String bookIdentifier, Book book) {
        return repository.addBook(bookIdentifier, book);
    }

    public Book getBook(String bookIdentifier) {
        return repository.getBook(bookIdentifier);
    }

    public HashMap<String, Book> getLibraryCatalog() {
        return repository.getLibraryCatalog();
    }

}
