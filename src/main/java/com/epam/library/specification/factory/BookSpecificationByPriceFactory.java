package com.epam.library.specification.factory;

import com.epam.library.specification.BookSpecification;
import com.epam.library.specification.BookSpecificationByPrice;

import java.math.BigDecimal;

public class BookSpecificationByPriceFactory implements BookSpecificationFactory {

    @Override
    public BookSpecification create(String query) {
        BigDecimal price = new BigDecimal(query);
        return new BookSpecificationByPrice(price);
    }
}
