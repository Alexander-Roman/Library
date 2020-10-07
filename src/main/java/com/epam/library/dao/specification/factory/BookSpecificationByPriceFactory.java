package com.epam.library.dao.specification.factory;

import com.epam.library.dao.specification.BookSpecification;
import com.epam.library.dao.specification.BookSpecificationByPrice;

public class BookSpecificationByPriceFactory implements BookSpecificationFactory {

    @Override
    public <T> BookSpecification create(T query) {
        return new BookSpecificationByPrice<T>(query);
    }
}
