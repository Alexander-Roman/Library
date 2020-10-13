package com.epam.library.dao.comparator;

import com.epam.library.entity.Book;

import java.util.Comparator;

public class BookYearComparator implements Comparator<Book> {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        int firstBookYear = firstBook.getYear();
        int secondBookYear = secondBook.getYear();
        return Integer.compare(firstBookYear, secondBookYear);
    }
}