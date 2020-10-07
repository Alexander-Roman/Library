package com.epam.library.dao.specification;

import com.epam.library.entity.Book;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class BookSpecificationByAuthorTest {

    private Book testBook;

    @BeforeClass
    public void setUp() {
        testBook = new Book
                .Builder(9781484228074L, "Pro Spring 5")
                .author("Iuliana Cosmina")
                .author("Rob Harrop")
                .author("Chris Schaefer")
                .build();
    }

    @AfterClass
    public void tearDown() {
        testBook = null;
    }

    @Test
    public void specifiedTestShouldReturnTrueWhenOneOfAuthorsMatches() {
        //given
        BookSpecification specification = new BookSpecificationByAuthor<String>("Rob Harrop");
        //when
        boolean actual = specification.specified(testBook);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void specifiedTestShouldReturnFalseWhenAuthorDoesNotMatch() {
        //given
        BookSpecification specification = new BookSpecificationByAuthor<String>("Bruce Eckel");
        //when
        boolean actual = specification.specified(testBook);
        //then
        Assert.assertFalse(actual);
    }
}
