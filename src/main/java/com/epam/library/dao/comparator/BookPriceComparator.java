package com.epam.library.dao.comparator;

import com.epam.library.entity.Book;

import java.math.BigDecimal;
import java.util.Comparator;

public class BookPriceComparator implements Comparator<Book> {

    @Override
    public int compare(Book firstBook, Book secondBook) {
        BigDecimal firstBookPrice = firstBook.getPrice();
        BigDecimal secondBookPrice = secondBook.getPrice();

        if (firstBookPrice == null && secondBookPrice == null) {
            return 0;
        } else if (firstBookPrice == null) {
            return -1;
        } else if (secondBookPrice == null) {
            return 1;
        }

        return firstBookPrice.compareTo(secondBookPrice);
    }
}