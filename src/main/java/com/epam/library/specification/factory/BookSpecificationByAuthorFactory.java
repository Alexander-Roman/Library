package com.epam.library.specification.factory;

import com.epam.library.specification.BookSpecification;
import com.epam.library.specification.BookSpecificationByAuthor;

public class BookSpecificationByAuthorFactory implements BookSpecificationFactory {

    @Override
    public BookSpecification create(String query) {
        return new BookSpecificationByAuthor(query);
    }
}
