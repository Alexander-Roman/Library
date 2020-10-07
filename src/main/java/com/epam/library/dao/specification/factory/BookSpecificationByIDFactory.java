package com.epam.library.dao.specification.factory;

import com.epam.library.dao.specification.BookSpecification;
import com.epam.library.dao.specification.BookSpecificationByID;

public class BookSpecificationByIDFactory implements BookSpecificationFactory {

    @Override
    public <T> BookSpecification create(T query) {
        return new BookSpecificationByID<T>(query);
    }
}
