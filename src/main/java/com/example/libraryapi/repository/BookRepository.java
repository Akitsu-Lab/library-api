package com.example.libraryapi.repository;

import com.example.libraryapi.domain.Book;
import com.example.libraryapi.domain.BookSelector;

import java.util.List;

public interface BookRepository {
    List<Book> findList(BookSelector selector);
    Book findOne(long bookId);
    Book lock(long bookId);
    void insert(Book book);
    void update(Book book);
    void delete(Book book);
}
