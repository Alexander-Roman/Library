package com.epam.library.data;

import com.epam.library.dao.BookDao;
import com.epam.library.dao.BookDaoImpl;
import com.epam.library.entity.Book;

import java.math.BigDecimal;

public class HardCodedBookDaoCreator implements BookDaoCreator {

    @Override
    public BookDao createBookDao() {
        BookDao bookDao = new BookDaoImpl();

        Book effectiveJava = new Book(1L, "Effective Java", "Joshua Bloch", 2017, BigDecimal.valueOf(46.40));
        bookDao.add(effectiveJava);

        Book cleanCode = new Book(2L, "Clean Code", "Robert Cecil Martin", 2009, BigDecimal.valueOf(41.72));
        bookDao.add(cleanCode);

        Book codeComplete = new Book(3L, "Code Complete", "Steve McConnell", 2004, BigDecimal.valueOf(54.99));
        bookDao.add(codeComplete);

        Book thinkingInJava = new Book(4L, "Thinking in Java", "Bruce Eckel", 2006, BigDecimal.valueOf(37.04));
        bookDao.add(thinkingInJava);

        Book proSpringFive = new Book(5L, "Pro Spring 5", "Iuliana Cosmina", 2017, BigDecimal.valueOf(29.99));
        bookDao.add(proSpringFive);

        Book javaTheCompleteReference = new Book(6L, "Java: The Complete Reference", "Herbert Schildt", 2018, BigDecimal.valueOf(22.97));
        bookDao.add(javaTheCompleteReference);

        Book javaEeSevenEssentials = new Book(7L, "Java EE 7 Essentials", "Arun Gupta", 2013, BigDecimal.valueOf(38.70));
        bookDao.add(javaEeSevenEssentials);

        return bookDao;
    }
}
