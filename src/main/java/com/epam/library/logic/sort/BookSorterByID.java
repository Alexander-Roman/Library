package com.epam.library.logic.sort;

import com.epam.library.entity.Book;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookSorterByID implements BookSorter {

    @Override
    public List<Book> sortAscending(List<Book> books) {
        Comparator<Book> comparator = Comparator.comparing(Book::getId);
        return books
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> sortDescending(List<Book> books) {
        Comparator<Book> comparator = Comparator.comparing(Book::getId).reversed();
        return books
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
