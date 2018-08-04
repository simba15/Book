package by.sazonov.book.presentation.util;

import by.sazonov.book.dao.BookListDao;
import by.sazonov.book.presentation.view.Menu;
import by.sazonov.book.service.BookListOperation;

import java.io.IOException;


public class Run {


    public static void main (String[]argv) {

        BookListOperation list = new BookListOperation(BookListDao.list);

        try {
            Menu.begin(list);
            BookListDao.closeApplication();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
