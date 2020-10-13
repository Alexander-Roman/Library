package com.epam.library.dao.specification.factory;

import com.epam.library.dao.specification.BookSpecification;
import com.epam.library.dao.specification.PriceSpecification;

public class PriceSpecificationFactory implements BookSpecificationFactory {

    @Override
    public BookSpecification create(String fieldValue) {
        return new PriceSpecification(fieldValue);
    }
}
