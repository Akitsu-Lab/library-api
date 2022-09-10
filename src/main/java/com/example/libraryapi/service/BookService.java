package com.example.libraryapi.service;

import com.example.libraryapi.domain.BookList;
import com.example.libraryapi.domain.BookSelector;

public interface BookService {
    BookList find(BookSelector selector);
}
