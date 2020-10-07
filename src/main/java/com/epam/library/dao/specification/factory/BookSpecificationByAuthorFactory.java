package com.epam.library.dao.specification.factory;

import com.epam.library.dao.specification.BookSpecification;
import com.epam.library.dao.specification.BookSpecificationByAuthor;

public class BookSpecificationByAuthorFactory implements BookSpecificationFactory {

    @Override
    public <T> BookSpecification create(T query) {
        return new BookSpecificationByAuthor<T>(query);
    }
}
