package service;

import dao.IBookDao;
import model.Book;

import java.util.*;

/**
 * Created by tr0k on 2014-07-06.
 */
public class BookService {
    private IBookDao bookDao;

    public void setBookDao(IBookDao bookDao) {
        this.bookDao = bookDao;
    }

    public List<Book> findBooksLent30DaysAgo() throws Exception {
        List<Book> booksLent30DaysAgo = new ArrayList<Book>();
        List<Book> allBooks = bookDao.findAll();

        Date thirtyDaysAgo = daysAgo(30);
        for (Book book : allBooks) {
            boolean bookWasLent30DaysAgo = book.getLendDate()
                    .compareTo(thirtyDaysAgo) <= 0;
            if (bookWasLent30DaysAgo)
                booksLent30DaysAgo.add(book);
        }

        return booksLent30DaysAgo;
    }

    private Date daysAgo(int days) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.add(Calendar.DATE, -days);
        return gc.getTime();
    }
}