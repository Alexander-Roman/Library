package com.epam.library.view;

import com.epam.library.entity.Book;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ConsoleBookView implements BookView {

    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void printBooksList(List<Book> books) {
        String separator = String.format("%.111s", "---------------------------------------------------------------------------------------------------------------");
        LOGGER.log(Level.INFO, separator);
        LOGGER.log(Level.INFO, getStringListFields());
        LOGGER.log(Level.INFO, separator);
        for (Book book : books) {
            LOGGER.log(Level.INFO, getStringBook(book));
        }
        LOGGER.log(Level.INFO, separator);
    }

    private String getStringBook(Book book) {
        return String.format("| %-13d | %-35.35s | %-35.35s | %-6d | %-6.2f |",
                book.getId(),
                book.getTitle(),
                getStringAuthors(book),
                book.getYear(),
                book.getPrice());
    }

    private String getStringAuthors(Book book) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String author : book.getAuthors()) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(author);
        }
        return stringBuilder.toString();
    }

    private String getStringListFields() {
        return String.format("| %-13s | %-35.35s | %-35.35s | %-6s | %-6.6s |",
                "ID",
                "TITLE",
                "AUTHORS",
                "YEAR",
                "PRICE");
    }

}
