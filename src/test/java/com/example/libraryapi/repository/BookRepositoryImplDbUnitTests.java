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
            assertEquals(3, books.size());
        }

        @Test
        public void testLock() throws Exception {
            Book book = target.lock(1);
            assertEquals(1,book.getBookId());
            assertEquals("Java",book.getBookTitle());
            assertEquals(332,book.getBookPages());
            assertEquals("Javaについて",book.getContent());
        }

        @Test
        public void testInsert() throws Exception {
            Book book = new Book();
            book.setBookTitle("PHP");
            book.setBookPages(22);
            book.setContent("PHPの本");
            target.insert(book);
        }

        @Test
        public void testUpdate() throws Exception {
            Book input = new Book();
            input.setBookId(1);
            input.setBookTitle("新Java");
            input.setBookPages(2);
            input.setContent("新しいJava");
            target.update(input);
        }

        @Test
        public void testDelete() throws Exception {
            Book input = new Book();
            input.setBookId(1);
            target.delete(input);
        }
    }

    static class FindTestExecutionListener extends AbstractTestExecutionListener {

    }
}
