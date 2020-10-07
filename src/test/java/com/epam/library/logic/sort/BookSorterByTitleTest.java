package com.epam.library.logic.sort;

import com.epam.library.entity.Book;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.List;

public class BookSorterByTitleTest {

    private final BookSorter sorter = new BookSorterByTitle();
    private List<Book> testBooks;
    private Book testBookFirst;
    private Book testBookSecond;
    private Book testBookThird;

    @BeforeClass
    public void setUp() {
        testBookFirst = new Book
                .Builder(9780134685991L, "Effective Java")
                .author("Joshua Bloch")
                .year(2017)
                .price(BigDecimal.valueOf(46.40))
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
                .author("Chris Schaefer")
                .year(2017)
                .price(BigDecimal.valueOf(29.99))
                .build();
        testBooks = List.of(testBookFirst, testBookSecond, testBookThird);
    }

    @Test
    public void sortAscendingTestShouldReturnListOfBooksSortedAscendingByTitle() {
        //given
        //when
        List<Book> actual = sorter.sortAscending(testBooks);
        //then
        List<Book> expected = List.of(testBookFirst, testBookThird, testBookSecond);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void sortDescendingTestShouldReturnListOfBooksSortedDescendingByTitle() {
        //given
        //when
        List<Book> actual = sorter.sortDescending(testBooks);
        //then
        List<Book> expected = List.of(testBookSecond, testBookThird, testBookFirst);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void sortAscendingTestShouldShouldNotModifyOriginalList() {
        //given
        //when
        List<Book> actual = sorter.sortAscending(testBooks);
        //then
        Assert.assertNotEquals(actual, testBooks);
    }

    @Test
    public void sortDescendingTestShouldNotModifyOriginalList() {
        //given
        //when
        List<Book> actual = sorter.sortDescending(testBooks);
        //then
        Assert.assertNotEquals(actual, testBooks);
    }
}
