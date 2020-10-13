package com.epam.library.dao.comparator;

import com.epam.library.entity.Book;

import java.util.Comparator;

public class BookIdComparator implements Comparator<Book> {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        long firstBookId = firstBook.getId();
        long secondBookId = secondBook.getId();
        return Long.compare(firstBookId, secondBookId);
    }
}
