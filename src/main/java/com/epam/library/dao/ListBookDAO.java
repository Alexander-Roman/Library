package com.epam.library.dao;

import com.epam.library.entity.Book;
import com.epam.library.entity.BookField;
import com.epam.library.specification.BookSpecification;
import com.epam.library.specification.factory.BookSpecificationFactory;
import com.epam.library.specification.factory.BookSpecificationFactoryProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ListBookDAO implements BookDAO {

    private final List<Book> books = new ArrayList<Book>();

    public ListBookDAO() {
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
    public List<Book> query(BookField bookField, String query) {
        BookSpecificationFactory factory = BookSpecificationFactoryProvider.createFactoryByBookField(bookField);
        BookSpecification specification = factory.create(query);

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
        ListBookDAO that = (ListBookDAO) o;
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
