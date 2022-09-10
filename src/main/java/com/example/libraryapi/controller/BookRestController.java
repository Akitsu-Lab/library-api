package com.example.libraryapi.controller;

import com.example.libraryapi.domain.Book;
import com.example.libraryapi.domain.BookList;
import com.example.libraryapi.domain.BookSelector;
import com.example.libraryapi.service.BookService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/{bookId}", produces = "application/json")
    public Book get(@PathVariable long bookId) {
        return this.service.get(bookId);
    }

    @PostMapping(path = "", produces = "application/json")
    public void add(@RequestBody Book book) {
        this.service.add(book);
    }

    @PatchMapping(path = "/{bookId}", produces = "application/json")
    public void set(@PathVariable long bookId, @RequestBody Book book) {
        book.setBookId(bookId);
        this.service.set(book);
    }

    @DeleteMapping(path = "/{bookId}", produces = "application/jons")
    public void remove(@PathVariable long bookId) {
        this.service.remove(bookId);
    }
}
