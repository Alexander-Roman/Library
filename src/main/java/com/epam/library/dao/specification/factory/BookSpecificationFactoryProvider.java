package com.epam.library.dao.specification.factory;

import com.epam.library.entity.BookField;

public class BookSpecificationFactoryProvider {

    public static BookSpecificationFactory createFactoryByBookField(BookField bookField) {
        switch (bookField) {
            case ID:
                return new BookSpecificationByIDFactory();
            case TITLE:
                return new BookSpecificationByTitleFactory();
            case AUTHOR:
                return new BookSpecificationByAuthorFactory();
            case YEAR:
                return new BookSpecificationByYearFactory();
            case PRICE:
                return new BookSpecificationByPriceFactory();
            default:
                throw new RuntimeException(bookField + " is unknown BookField!");
        }
    }
}
