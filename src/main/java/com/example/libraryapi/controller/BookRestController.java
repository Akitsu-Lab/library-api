package com.example.libraryapi.controller;

import com.example.libraryapi.domain.Book;
import com.example.libraryapi.domain.BookList;
import com.example.libraryapi.domain.BookSelector;
import com.example.libraryapi.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("services/v1/books")
public class BookRestController {
    private final BookService service;

    public BookRestController(BookService service) {
        this.service = service;
    }

    @GetMapping(path = "", produces = "application/json")
    public BookList find(BookSelector selector) {
        return this.service.find(selector);
    }

    public Book get(@PathVariable long bookId) {
        return this.service.get(bookId);
    }
}
