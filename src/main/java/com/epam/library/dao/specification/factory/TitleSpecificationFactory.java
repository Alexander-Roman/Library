package com.epam.library.dao.specification.factory;

import com.epam.library.dao.specification.BookSpecification;
import com.epam.library.dao.specification.TitleSpecification;

public class TitleSpecificationFactory implements BookSpecificationFactory {

    @Override
    public BookSpecification create(String fieldValue) {
        return new TitleSpecification(fieldValue);
    }
}
