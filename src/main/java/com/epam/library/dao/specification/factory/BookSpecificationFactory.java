package com.epam.library.dao.specification.factory;

import com.epam.library.dao.specification.BookSpecification;

public interface BookSpecificationFactory {

    BookSpecification create(String fieldValue);
}
