package com.example.libraryapi.domain;

import java.util.List;

public class BookList {
    private List<Book> bookList;

    public List<Book> getBookList() {
        return bookList;
    }

    //getterとsetter
    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }



}
