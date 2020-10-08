package com.epam.library.dao.specification;

import com.epam.library.entity.Book;

public class BookSpecificationByAuthor<T> extends AbstractBookSpecification<T> {

    public BookSpecificationByAuthor(T query) {
        super(query);
    }

    @Override
    public boolean specified(Book book) {
        String author = getQuery().toString();
        return book
                .getAuthors()
                .contains(author);
    }
}
