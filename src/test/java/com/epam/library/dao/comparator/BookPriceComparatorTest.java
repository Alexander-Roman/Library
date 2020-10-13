package com.epam.library.dao.comparator;

import com.epam.library.entity.Book;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Comparator;

public class BookPriceComparatorTest {

    private final static Comparator<Book> COMPARATOR = new BookPriceComparator();
    private final static Book TEST_BOOK_LESS = new Book(1L, "Effective Java", "Joshua Bloch", 2017, BigDecimal.valueOf(46.40));
    private final static Book TEST_BOOK_MORE = new Book(2L, "Code Complete", "Steve McConnell", 2004, BigDecimal.valueOf(54.99));
    private final static Book FIST_NULL_PRICE_BOOK = new Book(0L, null, null, 0, null);
    private final static Book SECOND_NULL_PRICE_BOOK = new Book(0L, null, null, 0, null);

    @Test
    public void testCompareShouldReturnNegativeWhenFirstBookPriceLess() {
        //given
        //when
        int actual = COMPARATOR.compare(TEST_BOOK_LESS, TEST_BOOK_MORE);
        //then
        Assert.assertTrue(actual < 0);
    }

    @Test
    public void testCompareShouldReturnNegativeWhenFirstBookPriceIsNull() {
        //given
        //when
        int actual = COMPARATOR.compare(FIST_NULL_PRICE_BOOK, TEST_BOOK_MORE);
        //then
        Assert.assertTrue(actual < 0);
    }

    @Test
    public void testCompareShouldReturnPositiveWhenFirstBookPriceMore() {
        //given
        //when
        int actual = COMPARATOR.compare(TEST_BOOK_MORE, TEST_BOOK_LESS);
        //then
        Assert.assertTrue(actual > 0);
    }

    @Test
    public void testCompareShouldReturnPositiveWhenSecondBookPriceIsNull() {
        //given
        //when
        int actual = COMPARATOR.compare(TEST_BOOK_LESS, SECOND_NULL_PRICE_BOOK);
        //then
        Assert.assertTrue(actual > 0);
    }

    @Test
    public void testCompareShouldReturnZeroWhenPricesAreEquals() {
        //given
        //when
        int actual = COMPARATOR.compare(TEST_BOOK_LESS, TEST_BOOK_LESS);
        //then
        Assert.assertEquals(actual, 0);
    }

    @Test
    public void testCompareShouldReturnZeroWhenPricesAreNull() {
        //given
        //when
        int actual = COMPARATOR.compare(FIST_NULL_PRICE_BOOK, SECOND_NULL_PRICE_BOOK);
        //then
        Assert.assertEquals(actual, 0);
    }
}
