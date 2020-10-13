package com.epam.library.dao.specification;

import com.epam.library.entity.Book;

public class TitleSpecification extends AbstractBookSpecification {

    public TitleSpecification(String fieldValue) {
        super(fieldValue);
    }

    @Override
    public boolean specified(Book book) {
        String titleRequired = getFieldValue();
        String bookTitle = book.getTitle();

        if (titleRequired == null) {
            return bookTitle == null;
        }

        return titleRequired.equalsIgnoreCase(bookTitle);
    }
}