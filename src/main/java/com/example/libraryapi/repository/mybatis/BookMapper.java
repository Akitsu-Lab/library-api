package com.example.libraryapi.repository.mybatis;

import com.example.libraryapi.domain.Book;
import com.example.libraryapi.domain.BookSelector;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BookMapper {
    List<Book> find(BookSelector selector);
    Book get(@Param("bookId") long bookId);
    Book lock(@Param("bookId") long bookId);
    int add(Book book);
    int set(Book book);
    int remove(Book book);
}
