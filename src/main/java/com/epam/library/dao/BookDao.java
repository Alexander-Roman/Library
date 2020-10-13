package com.epam.library.dao;

import com.epam.library.entity.Book;
import com.epam.library.entity.BookField;

import java.util.List;

public interface BookDao {

    void add(Book book);

    void remove(Book book);

    void update(Book book);

    List<Book> findByField(BookField bookField, String fieldValue);

    void sortByBookField(BookField bookField);
}
