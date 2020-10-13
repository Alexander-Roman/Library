package com.epam.library.dao.comparator;

import com.epam.library.entity.Book;

import java.util.Comparator;

public class BookAuthorComparator implements Comparator<Book> {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        String firstBookAuthor = firstBook.getAuthor();
        String secondBookAuthor = secondBook.getAuthor();

        if (firstBookAuthor == null && secondBookAuthor == null) {
            return 0;
        } else if (firstBookAuthor == null) {
            return -1;
        } else if (secondBookAuthor == null) {
            return 1;
        }

        return firstBookAuthor.compareToIgnoreCase(secondBookAuthor);
    }
}