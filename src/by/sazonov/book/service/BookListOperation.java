package by.sazonov.book.service;

import by.sazonov.book.entity.Book;


import java.util.ArrayList;
import java.util.Comparator;

public class BookListOperation {
    private ArrayList<Book> list;

    public BookListOperation(ArrayList<Book> list)  {
        if (list==null) {
            return;
        }
        this.list = list;
    }


    public void showBook() {
        for (Book e:list) {
            System.out.println(e);
        }
    }

    public void addBook (Book obj) {
        if (obj==null) {
            return;
        }
        list.add(obj);
    }

    public void removeBook (String name) {
        if (name==null) {
            return;
        }

        Book book = findByName(name);

        list.remove(book);
    }

    public void sortBooksByName() {
        list.sort(Comparator.comparing(Book::getName));
    }

    public void sortBooksByYear() {
        list.sort(Comparator.comparing(Book::getYear));
    }

    public void sortBooksByPages() {
        list.sort(Comparator.comparing(Book::getPage));
    }
    /*
    public void sortBooksByNameAuthor() {
        list.sort(Comparator.comparing(Book::getAuthor));
    }
    */

    public Book findByName(String name) {
        for (Book e:list) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }

    public Book findByYear(int year) {
        for (Book e:list) {
            if (e.getYear()==year) {
                return e;
            }
        }
        return null;
    }

    public Book findByPages(int page) {
        for (Book e:list) {
            if (e.getPage()==page) {
                return e;
            }
        }
        return null;
    }

    public Book findByAuthor(String firstName,String lastName) {
        for (Book e:list) {
            if ((e.getAuthor().getfirstName().equals(firstName))&&(e.getAuthor().getlastName().equals(lastName))) {
                return e;
            }
        }
        return null;
    }



}
