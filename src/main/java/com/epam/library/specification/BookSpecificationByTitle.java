package com.epam.library.specification;

import com.epam.library.entity.Book;

public class BookSpecificationByTitle implements BookSpecification {

    private final String title;

    public BookSpecificationByTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean specified(Book book) {
        return book
                .getTitle()
                .equals(title);
    }
}
