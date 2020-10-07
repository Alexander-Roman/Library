package com.epam.library.dao;

import com.epam.library.entity.Book;
import com.epam.library.entity.BookField;

import java.util.List;

public interface BookDAO {

    void addBook(Book book);

    void removeBook(Book book);

    void updateBook(Book book);

    <T> List<Book> query(BookField bookField, T query);

    List<Book> getSorted(BookField bookField);
}
