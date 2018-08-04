package by.sazonov.book.entity;

import java.util.Objects;

public class Book {

    private Author author;
    private int year;
    private String name;
    private int page;

    public Book() {

    }
    public Book(String name,int year,int page,String headName,String lastName) {

        this.name=name;
        this.year=year;
        this.page=page;

        this.author = new Author(headName,lastName);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public int getPage() {
        return page;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Book (" +
                "Name=" + name +
                ", Author=" + author +
                ", page=" + page +
                ", year=" + year +
                ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return year == book.year &&
                page == book.page &&
                Objects.equals(author, book.author) &&
                Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = prime + ((author==null)?0:author.hashCode()) + year + page + ((name==null?0:name.hashCode()));
        return result;
    }
}
