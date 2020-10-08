package com.epam.library.data;

import com.epam.library.dao.ListBookDAO;
import com.epam.library.entity.Book;

import java.math.BigDecimal;

public class HardCodeListBookDAOProvider implements ListBookDAOProvider {

    @Override
    public ListBookDAO getListBookDAO() {
        Book effectiveJava = new Book
                .Builder(9780134685991L, "Effective Java")
                .author("Joshua Bloch")
                .year(2017)
                .price(BigDecimal.valueOf(46.40))
                .build();

        Book cleanCode = new Book
                .Builder(9780132350884L, "Clean Code: A Handbook of Agile Software Craftsmanship")
                .author("Robert Cecil Martin")
                .year(2009)
                .price(BigDecimal.valueOf(41.72))
                .build();

        Book codeComplete = new Book
                .Builder(9780735619678L, "Code Complete: A Practical Handbook of Software Construction, Second Edition")
                .author("Steve McConnell")
                .year(2004)
                .price(BigDecimal.valueOf(54.99))
                .build();

        Book thinkingInJava = new Book
                .Builder(9780131872486L, "Thinking in Java")
                .author("Bruce Eckel")
                .year(2006)
                .price(BigDecimal.valueOf(37.04))
                .build();

        Book proSpringFive = new Book
                .Builder(9781484228074L, "Pro Spring 5: An In-Depth Guide to the Spring Framework and Its Tools")
                .author("Iuliana Cosmina")
                .author("Rob Harrop")
                .author("Chris Schaefer")
                .author("Clarence Ho")
                .year(2017)
                .price(BigDecimal.valueOf(29.99))
                .build();

        Book javaTheCompleteReference = new Book
                .Builder(9781260440232L, "Java: The Complete Reference, Eleventh Edition")
                .author("Herbert Schildt")
                .year(2018)
                .price(BigDecimal.valueOf(22.97))
                .build();

        Book javaEE7Essentials = new Book
                .Builder(9781449370176L, "Java EE 7 Essentials")
                .author("Arun Gupta")
                .year(2013)
                .price(BigDecimal.valueOf(38.70))
                .build();

        ListBookDAO listBookDAO = new ListBookDAO();
        listBookDAO.addBook(effectiveJava);
        listBookDAO.addBook(cleanCode);
        listBookDAO.addBook(codeComplete);
        listBookDAO.addBook(thinkingInJava);
        listBookDAO.addBook(proSpringFive);
        listBookDAO.addBook(javaTheCompleteReference);
        listBookDAO.addBook(javaEE7Essentials);

        return listBookDAO;
    }
}
