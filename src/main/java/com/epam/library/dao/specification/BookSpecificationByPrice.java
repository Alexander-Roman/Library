package com.epam.library.dao.specification;

import com.epam.library.entity.Book;

public class BookSpecificationByPrice<T> implements BookSpecification {

    private final T price;

    public BookSpecificationByPrice(T price) {
        this.price = price;
    }

    @Override
    public boolean specified(Book book) {
        return book
                .getPrice()
                .equals(price);
    }
}
