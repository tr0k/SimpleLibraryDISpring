package service;

import model.Book;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {

    @Test
    public void getBooksLent30DaysAgo() throws Exception {
        ApplicationContext appCtx = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
        BookService bookService = (BookService) appCtx.getBean("bookService");

        List<Book> booksLent30DaysAgo = bookService.findBooksLent30DaysAgo();

        assertEquals(2, booksLent30DaysAgo.size());
        assertEquals("Spring in Action", booksLent30DaysAgo.get(0).getTitle());
        assertEquals("Spring in Practice", booksLent30DaysAgo.get(1).getTitle());
    }
}
