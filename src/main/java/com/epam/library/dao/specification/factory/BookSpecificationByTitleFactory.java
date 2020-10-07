package com.epam.library.dao.specification.factory;

import com.epam.library.dao.specification.BookSpecification;
import com.epam.library.dao.specification.BookSpecificationByTitle;

public class BookSpecificationByTitleFactory implements BookSpecificationFactory {

    @Override
    public <T> BookSpecification create(T query) {
        return new BookSpecificationByTitle<T>(query);
    }
}
