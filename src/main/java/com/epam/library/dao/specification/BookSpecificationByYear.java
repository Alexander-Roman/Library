package com.epam.library.dao.specification;

import com.epam.library.entity.Book;

public class BookSpecificationByYear<T> implements BookSpecification {

    private final T year;

    public BookSpecificationByYear(T year) {
        this.year = year;
    }

    @Override
    public boolean specified(Book book) {
        return book.getYear() == Integer.parseInt(year.toString());
    }
}
