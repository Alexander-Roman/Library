package com.epam.library.dao.specification;

import com.epam.library.entity.Book;

public class BookSpecificationByTitle<T> extends AbstractBookSpecification<T> {

    public BookSpecificationByTitle(T query) {
        super(query);
    }

    @Override
    public boolean specified(Book book) {
        return book
                .getTitle()
                .equals(getQuery());
    }
}
