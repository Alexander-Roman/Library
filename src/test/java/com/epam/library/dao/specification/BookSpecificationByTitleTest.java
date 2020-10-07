package com.epam.library.dao.specification;

import com.epam.library.entity.Book;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;

public class BookSpecificationByTitleTest {

    private Book testBook;

    @BeforeClass
    public void setUp() {
        testBook = new Book
                .Builder(9780134685991L, "Effective Java")
                .author("Joshua Bloch")
                .year(2017)
                .price(BigDecimal.valueOf(46.40))
                .build();
    }

    @AfterClass
    public void tearDown() {
        testBook = null;
    }

    @Test
    public void specifiedTestShouldReturnTrueWhenTitleMatches() {
        //given
        BookSpecification specification = new BookSpecificationByTitle<String>("Effective Java");
        //when
        boolean actual = specification.specified(testBook);
        //then
        Assert.assertTrue(actual);
    }

    @Test
    public void specifiedTestShouldReturnFalseWhenTitleDoesNotMatch() {
        //given
        BookSpecification specification = new BookSpecificationByTitle<String>("Thinking in Java");
        //when
        boolean actual = specification.specified(testBook);
        //then
        Assert.assertFalse(actual);
    }
}
