package com.epam.library.dao.specification.factory;

import com.epam.library.dao.specification.BookSpecification;
import com.epam.library.dao.specification.IdSpecification;

public class IdSpecificationFactory implements BookSpecificationFactory {

    @Override
    public BookSpecification create(String fieldValue) {
        return new IdSpecification(fieldValue);
    }
}
