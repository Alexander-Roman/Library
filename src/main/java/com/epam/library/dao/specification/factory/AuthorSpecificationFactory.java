package com.epam.library.dao.specification.factory;

import com.epam.library.dao.specification.AuthorSpecification;
import com.epam.library.dao.specification.BookSpecification;

public class AuthorSpecificationFactory implements BookSpecificationFactory {

    @Override
    public BookSpecification create(String fieldValue) {
        return new AuthorSpecification(fieldValue);
    }
}
