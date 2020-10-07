package com.epam.library.specification;

import com.epam.library.entity.Book;

import java.math.BigDecimal;

public class BookSpecificationByPrice implements BookSpecification {

    private final BigDecimal price;

    public BookSpecificationByPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean specified(Book book) {
        return book
                .getPrice()
                .equals(price);
    }
}
