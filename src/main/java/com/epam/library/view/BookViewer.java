package com.epam.library.view;

import com.epam.library.entity.Book;

import java.util.List;

public interface BookViewer {

    void printBooksList(List<Book> books);
}
