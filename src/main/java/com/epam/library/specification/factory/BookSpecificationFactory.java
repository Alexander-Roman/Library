package com.epam.library.specification.factory;

import com.epam.library.specification.BookSpecification;

public interface BookSpecificationFactory {

    BookSpecification create(String query);
}
