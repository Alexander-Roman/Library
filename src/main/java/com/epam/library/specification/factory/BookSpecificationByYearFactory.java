package com.epam.library.specification.factory;

import com.epam.library.specification.BookSpecification;
import com.epam.library.specification.BookSpecificationByYear;

public class BookSpecificationByYearFactory implements BookSpecificationFactory {

    @Override
    public BookSpecification create(String query) {
        int year = Integer.parseInt(query);
        return new BookSpecificationByYear(year);
    }
}
