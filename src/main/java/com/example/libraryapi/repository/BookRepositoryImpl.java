package com.example.libraryapi.repository;

import com.example.libraryapi.domain.Book;
import com.example.libraryapi.domain.BookSelector;
import com.example.libraryapi.repository.mybatis.BookMapper;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private static final Logger logger = LoggerFactory.getLogger(BookRepositoryImpl.class);
    private final SqlSession sqlSession;

    public BookRepositoryImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<Book> findList(BookSelector selector) {
        logger.info("リスト表示成功");
        return this.sqlSession.getMapper(BookMapper.class).find(selector);
    }

    @Override
    public Book findOne(long bookId) {
        Book book = this.sqlSession.getMapper(BookMapper.class).get(bookId);

        if (book == null) {//TODO: ResourceNotFoundExceptionを記述
            logger.info("Book not found. id={}",bookId);
        }
        return book;
    }

    @Override
    public Book lock(long bookId) {
        Book book = this.sqlSession.getMapper(BookMapper.class).lock(bookId);
        if (book == null) {//TODO: ResourceNotFoundExceptionを記述
            logger.info("Book not found. id={}",bookId);
        }
        return book;
    }

    @Override
    public void insert(Book book) {
        this.sqlSession.getMapper(BookMapper.class).add(book);
    }

    @Override
    public void update(Book book) {
        int affected = this.sqlSession.getMapper(BookMapper.class).set(book);
        if (affected != 1) {//TODO: ResourceNotFoundExceptionを記述
            logger.info("Book not found. id={}",book.getBookId());
        }
    }

    @Override
    public void delete(Book book) {
        int affected = this.sqlSession.getMapper(BookMapper.class).remove(book);
        if (affected != 1) {//TODO: ResourceNotFoundExceptionを記述
            logger.info("Book not found. id={}",book.getBookId());
        }
    }

}
