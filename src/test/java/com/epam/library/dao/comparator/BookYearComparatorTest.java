package com.epam.library.dao.comparator;

import com.epam.library.entity.Book;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Comparator;

public class BookYearComparatorTest {

    private final static Comparator<Book> COMPARATOR = new BookYearComparator();
    private final static Book TEST_BOOK_LESS = new Book(2L, "Code Complete", "Steve McConnell", 2004, BigDecimal.valueOf(54.99));
    private final static Book TEST_BOOK_MORE = new Book(1L, "Effective Java", "Joshua Bloch", 2017, BigDecimal.valueOf(46.40));

    @Test
    public void testCompareShouldReturnNegativeWhenFirstBookYearLess() {
        //given
        //when
        int actual = COMPARATOR.compare(TEST_BOOK_LESS, TEST_BOOK_MORE);
        //then
        Assert.assertTrue(actual < 0);
    }

    @Test
    public void testCompareShouldReturnPositiveWhenFirstBookYearMore() {
        //given
        //when
        int actual = COMPARATOR.compare(TEST_BOOK_MORE, TEST_BOOK_LESS);
        //then
        Assert.assertTrue(actual > 0);
    }

    @Test
    public void testCompareShouldReturnZeroWhenYearsAreEquals() {
        //given
        //when
        int actual = COMPARATOR.compare(TEST_BOOK_LESS, TEST_BOOK_LESS);
        //then
        Assert.assertEquals(actual, 0);
    }
}
