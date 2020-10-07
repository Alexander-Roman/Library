package com.epam.library.dao.specification;

import com.epam.library.entity.Book;

public class BookSpecificationByAuthor<T> implements BookSpecification {

    private final T author;

    public BookSpecificationByAuthor(T author) {
        this.author = author;
    }

    @Override
    public boolean specified(Book book) {
        return book
                .getAuthors()
                .contains(author.toString());
    }
}
