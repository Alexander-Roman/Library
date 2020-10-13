package com.epam.library.dao.specification;

import com.epam.library.entity.Book;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class PriceSpecificationTest {

    private final static Book TEST_BOOK_REGULAR = new Book(1L, "Effective Java", "Joshua Bloch", 2017, BigDecimal.valueOf(46.40));
    private final static Book TEST_BOOK_NULL_PRICE = new Book(0L, null, null, 0, null);


    @Test
    public void testSpecifiedShouldReturnTrueWhenPriceMatches() {
        //given
        BookSpecification specification = new PriceSpecification("46.4");
        //when
        boolean actual = specification.specified(TEST_BOOK_REGULAR);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testSpecifiedShouldReturnTrueWhenNullPriceMatches() {
        //given
        BookSpecification specification = new PriceSpecification(null);
        //when
        boolean actual = specification.specified(TEST_BOOK_NULL_PRICE);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenPriceDoesNotMatch() {
        //given
        BookSpecification specification = new PriceSpecification("46.41");
        //when
        boolean actual = specification.specified(TEST_BOOK_REGULAR);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenOnlyRequiredPriceIsNull() {
        //given
        BookSpecification specification = new PriceSpecification(null);
        //when
        boolean actual = specification.specified(TEST_BOOK_REGULAR);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenOnlyRequiredPriceIsNotNull() {
        //given
        BookSpecification specification = new PriceSpecification("46.4");
        //when
        boolean actual = specification.specified(TEST_BOOK_NULL_PRICE);
        //then
        Assert.assertFalse(actual);
    }
}
