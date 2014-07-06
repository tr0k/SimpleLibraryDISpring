package dao;

import model.Book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by tr0k on 2014-07-06.
 */
public class CsvBookDao implements IBookDao {
    private String csvBooksFile;

    public void setCsvBooksFile(String csvBooksFile) {
        this.csvBooksFile = csvBooksFile;
    }

    @Override
    public List<Book> findAll() throws Exception {
        List<Book> booksList = new ArrayList<Book>();

        DateFormat df = new SimpleDateFormat("yyyyMMdd");

        BufferedReader br = new BufferedReader(new FileReader(csvBooksFile));
        String line;
        while ((line = br.readLine()) != null) {
            String[] fields = line.split(",");
            // pomijamy kwestie blednego formatu pliku
            String title = fields[0];
            String author = fields[1];
            Date lendDate = df.parse(fields[2]);
            Book book = new Book(title, author, lendDate);
            booksList.add(book);
        }
        br.close();
        return booksList;
    }
}
