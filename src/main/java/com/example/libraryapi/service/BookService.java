package com.example.libraryapi.service;

import com.example.libraryapi.domain.Book;
import com.example.libraryapi.domain.BookList;
import com.example.libraryapi.domain.BookSelector;

public interface BookService {
    BookList find(BookSelector selector);
    Book get(long bookId);
    void add(Book book);
    void set(Book book);
    void remove(long bookId);
}
