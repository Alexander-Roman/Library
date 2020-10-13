package com.epam.library.dao.specification;

import com.epam.library.entity.Book;

public class AuthorSpecification extends AbstractBookSpecification {

    public AuthorSpecification(String fieldValue) {
        super(fieldValue);
    }

    @Override
    public boolean specified(Book book) {
        String authorRequired = getFieldValue();
        String bookAuthor = book.getAuthor();

        if (authorRequired == null) {
            return bookAuthor == null;
        }

        return authorRequired.equalsIgnoreCase(bookAuthor);
    }
}
