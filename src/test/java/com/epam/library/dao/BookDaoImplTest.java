package com.epam.library.dao;

import com.epam.library.entity.Book;
import com.epam.library.entity.BookField;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BookDaoImplTest {

    private static final Book TEST_BOOK_FIRST = new Book(1L, "Effective Java", "Joshua Bloch", 2006, BigDecimal.valueOf(37.04));
    private static final Book TEST_BOOK_SECOND = new Book(2L, "Thinking in Java", "Bruce Eckel", 2017, BigDecimal.valueOf(37.04));
    private static final Book TEST_BOOK_THIRD = new Book(3L, "Pro Spring 5", "Iuliana Cosmina", 2017, BigDecimal.valueOf(29.99));

    @Test
    public void testFindByFieldShouldReturnSortedListOfSelectedBookFromPreviouslyAdded() {
        //given
        BookDao dao = new BookDaoImpl();
        //when
        dao.add(TEST_BOOK_FIRST);
        dao.add(TEST_BOOK_SECOND);
        dao.add(TEST_BOOK_THIRD);
        dao.sortByBookField(BookField.TITLE);
        List<Book> actual = dao.findByField(BookField.YEAR, "2017");
        //then
        List<Book> expected = Arrays.asList(TEST_BOOK_THIRD, TEST_BOOK_SECOND);
        Assert.assertEquals(actual, expected);
    }


    @Test
    public void testFindByFieldShouldReturnSortedListWithoutPreviouslyRemovedBooks() {
        //given
        BookDao dao = new BookDaoImpl();
        dao.add(TEST_BOOK_FIRST);
        dao.add(TEST_BOOK_SECOND);
        dao.add(TEST_BOOK_THIRD);
        //when
        dao.sortByBookField(BookField.PRICE);
        dao.remove(TEST_BOOK_FIRST);
        List<Book> actual = dao.findByField(BookField.YEAR, "2017");
        //then
        List<Book> expected = Arrays.asList(TEST_BOOK_THIRD, TEST_BOOK_SECOND);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindByFieldShouldReturnSortedListOfBooksMatchSpecifiedPrice() {
        //given
        BookDao dao = new BookDaoImpl();
        dao.add(TEST_BOOK_FIRST);
        dao.add(TEST_BOOK_SECOND);
        dao.add(TEST_BOOK_THIRD);
        //when
        dao.sortByBookField(BookField.AUTHOR);
        List<Book> actual = dao.findByField(BookField.PRICE, "37.04");
        //then
        List<Book> expected = Arrays.asList(TEST_BOOK_SECOND, TEST_BOOK_FIRST);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindByFieldShouldReturnListWithCorrectlyUpdatedByIdBooks() {
        //given
        BookDao dao = new BookDaoImpl();
        dao.add(TEST_BOOK_FIRST);
        dao.add(TEST_BOOK_SECOND);
        dao.add(TEST_BOOK_THIRD);
        Book thirdBookUpdated = new Book(3L, "Pro Spring 5", "Chris Schaefer", 2017, BigDecimal.valueOf(29.99));
        //when
        dao.update(thirdBookUpdated);
        List<Book> actual = dao.findByField(BookField.AUTHOR, "Chris Schaefer");
        //then
        List<Book> expected = Collections.singletonList(thirdBookUpdated);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testFindByFieldShouldReturnEmptyListIfNoBooksFound() {
        //given
        BookDao dao = new BookDaoImpl();
        dao.add(TEST_BOOK_FIRST);
        dao.add(TEST_BOOK_SECOND);
        dao.add(TEST_BOOK_THIRD);
        //when
        List<Book> actual = dao.findByField(BookField.ID, "4");
        //then
        List<Book> expected = Collections.emptyList();
        Assert.assertEquals(actual, expected);
    }

}
