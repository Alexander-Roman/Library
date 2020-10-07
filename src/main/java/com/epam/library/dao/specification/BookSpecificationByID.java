package com.epam.library.dao.specification;

import com.epam.library.entity.Book;

public class BookSpecificationByID<T> implements BookSpecification {

    private final T id;

    public BookSpecificationByID(T id) {
        this.id = id;
    }

    @Override
    public boolean specified(Book book) {
        return book.getId() == Long.parseLong(id.toString());
    }
}
