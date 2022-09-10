package com.example.libraryapi.repository;

import com.example.libraryapi.domain.Book;
import com.example.libraryapi.domain.BookSelector;

import java.util.List;

public interface BookRepository {
    List<Book> findList(BookSelector selector);
}
