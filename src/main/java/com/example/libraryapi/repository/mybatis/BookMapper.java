package com.example.libraryapi.repository.mybatis;

import com.example.libraryapi.domain.Book;
import com.example.libraryapi.domain.BookSelector;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    List<Book> find(BookSelector selector);
}
