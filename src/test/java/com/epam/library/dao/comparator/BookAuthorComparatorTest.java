package com.epam.library.dao.comparator;

import com.epam.library.entity.Book;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Comparator;

public class BookAuthorComparatorTest {

    private final static Comparator<Book> COMPARATOR = new BookAuthorComparator();
    private final static Book TEST_BOOK_LESS = new Book(1L, "Effective Java", "Joshua Bloch", 2017, BigDecimal.valueOf(46.40));
    private final static Book TEST_BOOK_MORE = new Book(2L, "Code Complete", "Steve McConnell", 2004, BigDecimal.valueOf(54.99));
    private final static Book FIST_NULL_AUTHOR_BOOK = new Book(0L, null, null, 0, null);
    private final static Book SECOND_NULL_AUTHOR_BOOK = new Book(0L, null, null, 0, null);

    @Test
    public void testCompareShouldReturnNegativeWhenFirstBookAuthorLess() {
        //given
        //when
        int actual = COMPARATOR.compare(TEST_BOOK_LESS, TEST_BOOK_MORE);
        //then
        Assert.assertTrue(actual < 0);
    }

    @Test
    public void testCompareShouldReturnNegativeWhenFirstBookAuthorIsNull() {
        //given
        //when
        int actual = COMPARATOR.compare(FIST_NULL_AUTHOR_BOOK, TEST_BOOK_MORE);
        //then
        Assert.assertTrue(actual < 0);
    }

    @Test
    public void testCompareShouldReturnPositiveWhenFirstBookAuthorMore() {
        //given
        //when
        int actual = COMPARATOR.compare(TEST_BOOK_MORE, TEST_BOOK_LESS);
        //then
        Assert.assertTrue(actual > 0);
    }

    @Test
    public void testCompareShouldReturnPositiveWhenSecondBookAuthorIsNull() {
        //given
        //when
        int actual = COMPARATOR.compare(TEST_BOOK_LESS, SECOND_NULL_AUTHOR_BOOK);
        //then
        Assert.assertTrue(actual > 0);
    }

    @Test
    public void testCompareShouldReturnZeroWhenAuthorsAreEquals() {
        //given
        //when
        int actual = COMPARATOR.compare(TEST_BOOK_LESS, TEST_BOOK_LESS);
        //then
        Assert.assertEquals(actual, 0);
    }

    @Test
    public void testCompareShouldReturnZeroWhenAuthorsAreNull() {
        //given
        //when
        int actual = COMPARATOR.compare(FIST_NULL_AUTHOR_BOOK, SECOND_NULL_AUTHOR_BOOK);
        //then
        Assert.assertEquals(actual, 0);
    }
}
