package com.epam.library.dao.specification;

import com.epam.library.entity.Book;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class YearSpecificationTest {

    private final static Book TEST_BOOK_REGULAR = new Book(1L, "Effective Java", "Joshua Bloch", 2017, BigDecimal.valueOf(46.40));
    private final static Book TEST_BOOK_ZERO_YEAR = new Book(0L, null, null, 0, null);

    @Test
    public void testSpecifiedShouldReturnTrueWhenYearMatches() {
        //given
        BookSpecification specification = new YearSpecification("2017");
        //when
        boolean actual = specification.specified(TEST_BOOK_REGULAR);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenYearDoesNotMatch() {
        //given
        BookSpecification specification = new YearSpecification("2016");
        //when
        boolean actual = specification.specified(TEST_BOOK_ZERO_YEAR);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenRequiredValueIsNull() {
        //given
        BookSpecification specification = new YearSpecification(null);
        //when
        boolean actual = specification.specified(TEST_BOOK_ZERO_YEAR);
        //then
        Assert.assertFalse(actual);
    }
}
