package com.epam.library.repository;

import com.epam.library.entity.Book;
import com.epam.library.specification.BookSpecification;

import java.util.List;

public interface BookRepository {

    void addBook(Book book);

    void removeBook(Book book);

    void updateBook(Book book);

    List<Book> query(BookSpecification specification);

    List<Book> getAllBooks();

}
