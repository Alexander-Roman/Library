package com.epam.library.dao.specification;

import com.epam.library.entity.Book;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;


public class AuthorSpecificationTest {

    private static final Book TEST_BOOK_REGULAR = new Book(5L, "Pro Spring 5", "Iuliana Cosmina", 2017, BigDecimal.valueOf(29.99));
    private static final Book TEST_BOOK_NULL_AUTHOR = new Book(0L, null, null, 0, null);


    @Test
    public void testSpecifiedShouldReturnTrueWhenAuthorMatchesIgnoreCase() {
        //given
        BookSpecification specification = new AuthorSpecification("iuliana cosmina");
        //when
        boolean actual = specification.specified(TEST_BOOK_REGULAR);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testSpecifiedShouldReturnTrueWhenNullAuthorMatches() {
        //given
        BookSpecification specification = new AuthorSpecification(null);
        //when
        boolean actual = specification.specified(TEST_BOOK_NULL_AUTHOR);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenAuthorDoesNotMatch() {
        //given
        BookSpecification specification = new AuthorSpecification("Bruce Eckel");
        //when
        boolean actual = specification.specified(TEST_BOOK_REGULAR);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenOnlyRequestedAuthorIsNull() {
        //given
        BookSpecification specification = new AuthorSpecification(null);
        //when
        boolean actual = specification.specified(TEST_BOOK_REGULAR);
        //then
        Assert.assertFalse(actual);
    }

    @Test
    public void testSpecifiedShouldReturnFalseWhenOnlyRequestedAuthorIsNotNull() {
        //given
        BookSpecification specification = new AuthorSpecification("Bruce Eckel");
        //when
        boolean actual = specification.specified(TEST_BOOK_NULL_AUTHOR);
        //then
        Assert.assertFalse(actual);
    }
}
