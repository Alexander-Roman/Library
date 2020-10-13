package com.epam.library.dao.comparator;

import com.epam.library.entity.Book;
import com.epam.library.entity.BookField;

import java.util.Comparator;

public class BookComparatorFactory {

    public static Comparator<Book> createByBookField(BookField bookField) {
        switch (bookField) {
            case ID:
                return new BookIdComparator();
            case TITLE:
                return new BookTitleComparator();
            case AUTHOR:
                return new BookAuthorComparator();
            case YEAR:
                return new BookYearComparator();
            case PRICE:
                return new BookPriceComparator();
            default:
                throw new IllegalArgumentException(bookField + " is unknown BookField!");
        }
    }
}
