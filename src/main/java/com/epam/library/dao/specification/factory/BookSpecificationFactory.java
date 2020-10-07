package com.epam.library.dao.specification.factory;

import com.epam.library.dao.specification.BookSpecification;

public interface BookSpecificationFactory {

    <T> BookSpecification create(T query);
}
