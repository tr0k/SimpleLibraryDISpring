package dao;

import model.Book;

import java.util.List;

/**
 * Created by tr0k on 2014-07-06.
 */
public interface IBookDao {
    List<Book> findAll() throws Exception;
}

