package com.example.libraryapi.service;

import com.example.libraryapi.domain.Book;
import com.example.libraryapi.domain.BookList;
import com.example.libraryapi.domain.BookSelector;
import com.example.libraryapi.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository repository;

    public BookServiceImpl(BookRepository repository) {
        this.repository = repository;
    }

    @Override
    public BookList find(BookSelector selector) {
        BookList bookList = new BookList();
        bookList.setBookList(this.repository.findList(selector));
        return bookList;
    }

    @Override
    public Book get(long bookId) {
        return this.repository.findOne(bookId);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void add(Book book) {
        this.repository.insert(book);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void set(Book book) {
        this.repository.lock(book.getBookId());
        this.repository.update(book);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void remove(long bookId) {
        Book target = this.repository.lock(bookId);
        this.repository.delete(target);
    }
}
