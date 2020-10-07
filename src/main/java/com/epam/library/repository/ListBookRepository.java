package com.epam.library.repository;

import com.epam.library.entity.Book;
import com.epam.library.specification.BookSpecification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ListBookRepository implements BookRepository {

    private final List<Book> books = new ArrayList<Book>();

    public ListBookRepository() {
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void removeBook(Book book) {
        books.remove(book);
    }

    @Override
    public void updateBook(Book book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == book.getId()) {
                books.set(i, book);
            }
        }
    }

    @Override
    public List<Book> query(BookSpecification specification) {
        return books
                .stream()
                .filter(specification::specified)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooks() {
        return Collections.unmodifiableList(books);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListBookRepository that = (ListBookRepository) o;
        return Objects.equals(books, that.books);
    }

    @Override
    public int hashCode() {
        return books.hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "books=" + books +
                '}';
    }
}
