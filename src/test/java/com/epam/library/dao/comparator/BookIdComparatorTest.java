package com.epam.library.dao.comparator;

import com.epam.library.entity.Book;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Comparator;

public class BookIdComparatorTest {

    private final static Comparator<Book> COMPARATOR = new BookIdComparator();
    private final static Book TEST_BOOK_LESS = new Book(1L, "Effective Java", "Joshua Bloch", 2017, BigDecimal.valueOf(46.40));
    private final static Book TEST_BOOK_MORE = new Book(2L, "Code Complete", "Steve McConnell", 2004, BigDecimal.valueOf(54.99));

    @Test
    public void testCompareShouldReturnNegativeWhenFirstBookIdLess() {
        //given
        //when
        int actual = COMPARATOR.compare(TEST_BOOK_LESS, TEST_BOOK_MORE);
        //then
        Assert.assertTrue(actual < 0);
    }

    @Test
    public void testCompareShouldReturnPositiveWhenFirstBookIdMore() {
        //given
        //when
        int actual = COMPARATOR.compare(TEST_BOOK_MORE, TEST_BOOK_LESS);
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

}
