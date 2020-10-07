package com.epam.library.dao;

import com.epam.library.entity.Book;
import com.epam.library.entity.BookField;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;

public class ListBookDAOTest {

    private final BookDAO dao = new ListBookDAO();
    private Book testBookFirst;
    private Book testBookSecond;
    private Book testBookThird;

    @BeforeClass
    public void setUp() {
        testBookFirst = new Book
                .Builder(9780134685991L, "Effective Java")
                .author("Joshua Bloch")
                .year(2017)
                .price(BigDecimal.valueOf(37.04))
                .build();
        testBookSecond = new Book
                .Builder(9780131872486L, "Thinking in Java")
                .author("Bruce Eckel")
                .year(2006)
                .price(BigDecimal.valueOf(37.04))
                .build();
        testBookThird = new Book
                .Builder(9781484228074L, "Pro Spring 5: An In-Depth Guide to the Spring Framework and Its Tools")
                .author("Iuliana Cosmina")
                .author("Rob Harrop")
                .year(2017)
                .price(BigDecimal.valueOf(29.99))
                .build();
        dao.addBook(testBookFirst);
        dao.addBook(testBookSecond);
        dao.addBook(testBookThird);
    }

    @Test
    public void queryTestShouldReturnListOfSelectedFromPreviouslyAddedBooks() {
        //given
        //when
        List<Book> actual = dao.query(BookField.YEAR, 2017);
        //then
        List<Book> expected = List.of(testBookFirst, testBookThird);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void queryTestShouldReturnListWithoutPreviouslyRemovedBooks() {
        //given
        //when
        dao.removeBook(testBookFirst);
        List<Book> actual = dao.query(BookField.PRICE, BigDecimal.valueOf(37.04));
        //then
        List<Book> expected = List.of(testBookSecond);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void queryTestShouldReturnListWithCorrectlyUpdatedByIdBooks() {
        //given
        Book thirdBookUpdated = new Book
                .Builder(9781484228074L, "Pro Spring 5: An In-Depth Guide to the Spring Framework and Its Tools")
                .author("Iuliana Cosmina")
                .author("Rob Harrop")
                .author("Chris Schaefer")
                .year(2017)
                .price(BigDecimal.valueOf(29.99))
                .build();
        //when
        dao.updateBook(thirdBookUpdated);
        List<Book> actual = dao.query(BookField.AUTHOR, "Chris Schaefer");
        //then
        List<Book> expected = List.of(thirdBookUpdated);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void queryTestShouldReturnEmptyListIfNoBooksFound() {
        //given
        //when
        List<Book> actual = dao.query(BookField.ID, 97814842280745L);
        //then
        List<Book> expected = List.of();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void queryTestShouldReturnListOfBooksMatchSpecifiedTitle() {
        //given
        //when
        List<Book> actual = dao.query(BookField.TITLE, "Thinking in Java");
        //then
        List<Book> expected = List.of(testBookSecond);
        Assert.assertEquals(actual, expected);
    }


}
