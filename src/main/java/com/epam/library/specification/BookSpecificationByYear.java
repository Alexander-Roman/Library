package com.epam.library.specification;

import com.epam.library.entity.Book;

public class BookSpecificationByYear implements BookSpecification {

    private final int year;

    public BookSpecificationByYear(int year) {
        this.year = year;
    }

    @Override
    public boolean specified(Book book) {
        return book.getYear() == year;
    }
}
