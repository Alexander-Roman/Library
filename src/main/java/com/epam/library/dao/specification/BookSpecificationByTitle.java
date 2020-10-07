package com.epam.library.dao.specification;

import com.epam.library.entity.Book;

public class BookSpecificationByTitle<T> implements BookSpecification {

    private final T title;

    public BookSpecificationByTitle(T title) {
        this.title = title;
    }

    @Override
    public boolean specified(Book book) {
        return book
                .getTitle()
                .equals(title);
    }
}
