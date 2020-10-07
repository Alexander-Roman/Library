package com.epam.library.specification;

import com.epam.library.entity.Book;

public class BookSpecificationByID implements BookSpecification {

    private final long id;

    public BookSpecificationByID(long id) {
        this.id = id;
    }

    @Override
    public boolean specified(Book book) {
        return book.getId() == id;
    }
}
