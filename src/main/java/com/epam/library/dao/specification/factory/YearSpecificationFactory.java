package com.epam.library.dao.specification.factory;

import com.epam.library.dao.specification.BookSpecification;
import com.epam.library.dao.specification.YearSpecification;

public class YearSpecificationFactory implements BookSpecificationFactory {

    @Override
    public BookSpecification create(String fieldValue) {
        return new YearSpecification(fieldValue);
    }
}
