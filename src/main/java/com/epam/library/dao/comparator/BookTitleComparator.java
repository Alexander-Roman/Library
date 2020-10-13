package com.epam.library.dao.comparator;

import com.epam.library.entity.Book;

import java.util.Comparator;

public class BookTitleComparator implements Comparator<Book> {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        String firstBookTitle = firstBook.getTitle();
        String secondBookTitle = secondBook.getTitle();

        if (firstBookTitle == null && secondBookTitle == null) {
            return 0;
        } else if (firstBookTitle == null) {
            return -1;
        } else if (secondBookTitle == null) {
            return 1;
        }

        return firstBookTitle.compareTo(secondBookTitle);
    }
}