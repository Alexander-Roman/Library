package com.epam.library.specification;

import com.epam.library.entity.Book;

public class BookSpecificationByAuthor implements BookSpecification {

    private final String author;

    public BookSpecificationByAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean specified(Book book) {
        return book
                .getAuthors()
                .contains(author);
    }
}
