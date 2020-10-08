package com.epam.library.dao.specification;

import com.epam.library.entity.Book;

public class BookSpecificationByID<T> extends AbstractBookSpecification<T> {

    public BookSpecificationByID(T query) {
        super(query);
    }

    @Override
    public boolean specified(Book book) {
        long id = Long.parseLong(getQuery().toString());
        return book.getId() == id;
    }
}