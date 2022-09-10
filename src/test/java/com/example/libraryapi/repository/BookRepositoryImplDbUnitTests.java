package com.example.libraryapi.repository;

import com.example.libraryapi.LibraryApiApplication;
import com.example.libraryapi.domain.Book;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.AbstractTestExecutionListener;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookRepositoryImplDbUnitTests {

    @SpringBootTest(classes = LibraryApiApplication.class)
    @TestExecutionListeners({DependencyInjectionTestExecutionListener.class, FindTestExecutionListener.class})
    @Nested
    public class FindDbTest extends AbstractTestExecutionListener {

        @Autowired
        private BookRepository target;

        @Test
        public void testFindAll() throws Exception {
            List<Book> books = target.findList(null);
            assertEquals(3,books.size());
        }

        @Test
        public void testInsert() throws Exception {
            Book book = new Book();
            book.setBookTitle("PHP");
            book.setPages(22);
            book.setContent("PHPの本");
            target.insert(book);
        }
    }

    static class FindTestExecutionListener extends AbstractTestExecutionListener {

    }
}
