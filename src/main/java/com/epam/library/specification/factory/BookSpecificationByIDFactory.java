package com.epam.library.specification.factory;

import com.epam.library.specification.BookSpecification;
import com.epam.library.specification.BookSpecificationByID;

public class BookSpecificationByIDFactory implements BookSpecificationFactory {

    @Override
    public BookSpecification create(String query) {
        long id = Long.parseLong(query);
        return new BookSpecificationByID(id);
    }
}
