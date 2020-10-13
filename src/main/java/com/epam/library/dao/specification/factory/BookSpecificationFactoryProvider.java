package com.epam.library.dao.specification.factory;

import com.epam.library.entity.BookField;

public class BookSpecificationFactoryProvider {

    public static BookSpecificationFactory createFactoryByBookField(BookField bookField) {
        switch (bookField) {
            case ID:
                return new IdSpecificationFactory();
            case TITLE:
                return new TitleSpecificationFactory();
            case AUTHOR:
                return new AuthorSpecificationFactory();
            case YEAR:
                return new YearSpecificationFactory();
            case PRICE:
                return new PriceSpecificationFactory();
            default:
                throw new IllegalArgumentException(bookField + " is unknown BookField!");
        }
    }
}
