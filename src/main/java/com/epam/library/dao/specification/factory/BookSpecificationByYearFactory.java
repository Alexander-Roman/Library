package com.epam.library.dao.specification.factory;

import com.epam.library.dao.specification.BookSpecification;
import com.epam.library.dao.specification.BookSpecificationByYear;

public class BookSpecificationByYearFactory implements BookSpecificationFactory {

    @Override
    public <T> BookSpecification create(T query) {
        return new BookSpecificationByYear<T>(query);
    }
}
