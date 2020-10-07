package com.epam.library.logic.sort;

import com.epam.library.entity.BookField;

public class BookSorterFactory {

    public static BookSorter creteBookSorterByBookField(BookField bookField) {
        switch (bookField) {
            case ID:
                return new BookSorterByID();
            case TITLE:
                return new BookSorterByTitle();
            case AUTHOR:
                return new BookSorterByAuthor();
            case YEAR:
                return new BookSorterByYear();
            case PRICE:
                return new BookSorterByPrice();
            default:
                throw new RuntimeException(bookField + " is unknown BookField");
        }
    }
}
