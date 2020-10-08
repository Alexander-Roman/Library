package com.epam.library.dao.specification;

import com.epam.library.entity.Book;

public class BookSpecificationByYear<T> extends AbstractBookSpecification<T> {

    public BookSpecificationByYear(T query) {
        super(query);
    }

    @Override
    public boolean specified(Book book) {
        int year = Integer.parseInt(getQuery().toString());
        return book.getYear() == year;
    }
}
