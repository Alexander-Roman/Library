package com.epam.library.specification.factory;

import com.epam.library.specification.BookSpecification;
import com.epam.library.specification.BookSpecificationByTitle;

public class BookSpecificationByTitleFactory implements BookSpecificationFactory {

    @Override
    public BookSpecification create(String query) {
        return new BookSpecificationByTitle(query);
    }
}
