package com.epam.library.dao.specification;

import com.epam.library.entity.Book;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class TitleSpecificationTest {

    private final static Book TEST_BOOK_REGULAR = new Book(1L, "Effective Java", "Joshua Bloch", 2017, BigDecimal.valueOf(46.40));
    private final static Book TEST_BOOK_NULL_TITLE = new Book(0L, null, null, 0, null);

    @Test
    public void testSpecifiedShouldReturnTrueWhenTitleMatches() {
        //given
        BookSpecification specification = new TitleSpecification("Effective Java");
        //when
        boolean actual = specification.specified(TEST_BOOK_REGULAR);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testSpecifiedShouldReturnTrueWhenNullTitleMatches() {
        //given
        BookSpecification specification = new TitleSpecification(null);
        //when
        boolean actual = specification.specified(TEST_BOOK_NULL_TITLE);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenTitleDoesNotMatch() {
        //given
        BookSpecification specification = new TitleSpecification("Thinking in Java");
        //when
        boolean actual = specification.specified(TEST_BOOK_REGULAR);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenOnlyRequiredTitleIsNull() {
        //given
        BookSpecification specification = new TitleSpecification(null);
        //when
        boolean actual = specification.specified(TEST_BOOK_REGULAR);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenOnlyRequiredTitleIsNotNull() {
        //given
        BookSpecification specification = new TitleSpecification("Thinking in Java");
        //when
        boolean actual = specification.specified(TEST_BOOK_NULL_TITLE);
        //then
        Assert.assertFalse(actual);
    }
}
