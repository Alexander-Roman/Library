package com.epam.library.dao.specification;

import com.epam.library.entity.Book;

public class BookSpecificationByPrice<T> extends AbstractBookSpecification<T> {

    public BookSpecificationByPrice(T query) {
        super(query);
    }

    @Override
    public boolean specified(Book book) {
        return book
                .getPrice()
                .equals(getQuery());
    }
}
