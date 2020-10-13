package com.epam.library.dao;

import com.epam.library.dao.comparator.BookComparatorFactory;
import com.epam.library.dao.specification.BookSpecification;
import com.epam.library.dao.specification.factory.BookSpecificationFactory;
import com.epam.library.dao.specification.factory.BookSpecificationFactoryProvider;
import com.epam.library.entity.Book;
import com.epam.library.entity.BookField;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookDaoImpl implements BookDao {

    private final List<Book> books = new ArrayList<Book>();

    public BookDaoImpl() {
    }

    @Override
    public void add(Book book) {
        books.add(book);
    }

    @Override
    public void remove(Book book) {
        books.remove(book);
    }

    @Override
    public void update(Book book) {
        long target = book.getId();
        for (int i = 0; i < books.size(); i++) {
            Book current = books.get(i);
            if (current.getId() == target) {
                books.set(i, book);
            }
        }
    }

    @Override
    public List<Book> findByField(BookField bookField, String fieldValue) {
        BookSpecificationFactory factory = BookSpecificationFactoryProvider.createFactoryByBookField(bookField);
        BookSpecification specification = factory.create(fieldValue);

        List<Book> filtered = new ArrayList<Book>();
        for (Book book : books) {
            if (specification.specified(book)) {
                filtered.add(book);
            }
        }
        return filtered;
    }

    @Override
    public void sortByBookField(BookField bookField) {
        Comparator<Book> comparator = BookComparatorFactory.createByBookField(bookField);
        Collections.sort(books, comparator);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "books=" + books +
                '}';
    }
}
