package com.epam.library.dao.specification;

import com.epam.library.entity.Book;

import java.math.BigDecimal;

public class PriceSpecification extends AbstractBookSpecification {

    private final BigDecimal priceRequired;

    public PriceSpecification(String fieldValue) {
        super(fieldValue);
        priceRequired = fieldValue == null
                ? null
                : new BigDecimal(fieldValue);
    }

    @Override
    public boolean specified(Book book) {
        BigDecimal bookPrice = book.getPrice();

        if (priceRequired == null) {
            return bookPrice == null;
        }

        return priceRequired.equals(bookPrice);
    }
}
