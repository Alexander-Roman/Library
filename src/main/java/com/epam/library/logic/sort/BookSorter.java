package com.epam.library.logic.sort;

import com.epam.library.entity.Book;

import java.util.List;

public interface BookSorter {

    List<Book> sortAscending(List<Book> books);

    List<Book> sortDescending(List<Book> books);

}
