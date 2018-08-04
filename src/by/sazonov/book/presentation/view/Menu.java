package by.sazonov.book.presentation.view;

import by.sazonov.book.dao.BookListDao;
import by.sazonov.book.entity.Book;
import by.sazonov.book.scanner.ScanFromConsole;
import by.sazonov.book.service.BookListOperation;

import java.io.IOException;

public class Menu {
    public static void begin (BookListOperation list ) throws IOException {
        int choice = 0;
        do {
            System.out.println("1.Add new book\n" +
                               "2.Remove book\n" +
                               "3.Find book by tag\n" +
                               "4.Sort of book by tag\n" +
                               "5.Show books\n");
            choice = ScanFromConsole.getInt();
            switch (choice) {
                case 1:
                    add(list);
                    break;
                case 2:
                    dell(list);
                    break;
                case 3:
                    find(list);
                    break;
                case 4:
                    sort(list);
                    break;
                case 5:
                    list.showBook();
                    break;
            }
        } while (choice!=0);

    }

    private static void add(BookListOperation list ) {

        System.out.println("Enter the name Book");
        String name = ScanFromConsole.getString();
        try {
            if (list.findByName(name)!=null) {
                //System.out.println("Exception // Книга существует");
                throw new Exception("Книга существует");

            }
        } catch (Exception e) {
            System.out.println(e);
            return;
        }
        System.out.println("Enter the year");
        int year = ScanFromConsole.getInt();
        System.out.println("Enter the pages");
        int page = ScanFromConsole.getInt();
        System.out.println("Enter the name author ");
        String firstName = ScanFromConsole.getString();
        String lastName = ScanFromConsole.getString();
        list.addBook(new Book(name,year,page,firstName,lastName));
    }

    private static void find(BookListOperation list ) {
        System.out.println("Choice tag by find");
        System.out.println( "1.Name Book\n" +
                            "2.Year\n" +
                            "3.Pages\n" +
                            "4.Name author\n");
        int choice = ScanFromConsole.getInt();
        Book example = new Book();
        System.out.println("Enter the tag");
        switch (choice) {
            case 1:
                example=list.findByName(ScanFromConsole.getString());
                break;
            case 2:
                example=list.findByYear(ScanFromConsole.getInt());
                break;
            case 3:
                example=list.findByPages(ScanFromConsole.getInt());
                break;
            case 4:
                example=list.findByAuthor(ScanFromConsole.getString(),ScanFromConsole.getString());
                break;
        }
        if (example!=null) {
            System.out.println(example);
        }
    }

    private static void dell (BookListOperation list) {
        String nameBook = ScanFromConsole.getString();
        try {
            if (list.findByName(nameBook)==null) {
                //System.out.println("Exception // Книга не существует");
                throw new Exception("Книги не существует");
            }
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        list.removeBook(nameBook);
    }
    private static void sort (BookListOperation list) {
        System.out.println("Choice tag by sort");
        System.out.println( "1.Name Book\n" +
                "2.Year\n" +
                "3.Pages\n" +
                "4.Name author\n");
        int choice = ScanFromConsole.getInt();
        System.out.println("Enter the tag");
        switch (choice) {
            case 1:
                list.sortBooksByName();
                break;
            case 2:
                list.sortBooksByYear();
                break;
            case 3:
                list.sortBooksByPages();
                break;
        }
    }
}
