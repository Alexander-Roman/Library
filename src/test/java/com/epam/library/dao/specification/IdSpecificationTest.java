package com.epam.library.dao.specification;

import com.epam.library.entity.Book;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class IdSpecificationTest {

    private final static Book TEST_BOOK_REGULAR = new Book(1L, "Effective Java", "Joshua Bloch", 2017, BigDecimal.valueOf(46.40));
    private final static Book TEST_BOOK_ZERO_ID = new Book(0L, null, null, 0, null);

    @Test
    public void testSpecifiedShouldReturnTrueWhenIdMatches() {
        //given
        BookSpecification specification = new IdSpecification("1");
        //when
        boolean actual = specification.specified(TEST_BOOK_REGULAR);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenIdDoesNotMatch() {
        //given
        BookSpecification specification = new IdSpecification("1");
        //when
        boolean actual = specification.specified(TEST_BOOK_ZERO_ID);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenRequiredValueIsNull() {
        //given
        BookSpecification specification = new IdSpecification(null);
        //when
        boolean actual = specification.specified(TEST_BOOK_ZERO_ID);
        //then
        Assert.assertFalse(actual);
    }
}
