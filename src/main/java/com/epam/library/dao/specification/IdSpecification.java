package com.epam.library.dao.specification;

import com.epam.library.entity.Book;

public class IdSpecification extends AbstractBookSpecification {

    public IdSpecification(String fieldValue) {
        super(fieldValue);
    }

    @Override
    public boolean specified(Book book) {
        String idRequired = getFieldValue();
        long bookId = book.getId();
        return idRequired != null &&
                Long.parseLong(idRequired) == bookId;
    }
}