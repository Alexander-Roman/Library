package com.epam.library.dao.specification;

import com.epam.library.entity.Book;

public class YearSpecification extends AbstractBookSpecification {

    public YearSpecification(String fieldValue) {
        super(fieldValue);
    }

    @Override
    public boolean specified(Book book) {
        String idRequired = getFieldValue();
        int bookYear = book.getYear();
        return idRequired != null &&
                Integer.parseInt(idRequired) == bookYear;
    }
}
