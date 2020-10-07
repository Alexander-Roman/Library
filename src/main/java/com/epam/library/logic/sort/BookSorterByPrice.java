package com.epam.library.logic.sort;

import com.epam.library.entity.Book;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookSorterByPrice implements BookSorter {

    private final Comparator<Book> comparator = Comparator.comparing(Book::getPrice);

    @Override
    public List<Book> sortAscending(List<Book> books) {
        return books
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> sortDescending(List<Book> books) {
        return books
                .stream()
                .sorted(comparator.reversed())
                .collect(Collectors.toList());
    }
}
