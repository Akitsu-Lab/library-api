package com.example.libraryapi.repository;

import com.example.libraryapi.domain.Book;
import com.example.libraryapi.domain.BookSelector;
import com.example.libraryapi.repository.mybatis.BookMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private final SqlSession sqlSession;

    public BookRepositoryImpl(SqlSession sqlSession, SqlSession sqlSession1) {
        this.sqlSession = sqlSession1;
    }

    @Override
    public List<Book> findList(BookSelector selector) {
        return this.sqlSession.getMapper(BookMapper.class).find(selector);
    }
}
