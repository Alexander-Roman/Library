package com.epam.library.main;

import com.epam.library.dao.BookDao;
import com.epam.library.data.BookDaoCreator;
import com.epam.library.data.HardCodedBookDaoCreator;
import com.epam.library.entity.Book;
import com.epam.library.entity.BookField;
import com.epam.library.view.BookViewer;
import com.epam.library.view.ConsoleBookViewer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Runner {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {

        BookDaoCreator provider = new HardCodedBookDaoCreator();
        BookDao bookDAO = provider.createBookDao();

        LOGGER.log(Level.INFO, "List of 2017 books sorted by author:");
        bookDAO.sortByBookField(BookField.AUTHOR);
        List<Book> queried = bookDAO.findByField(BookField.YEAR, "2017");
        BookViewer viewer = new ConsoleBookViewer();
        viewer.printBooksList(queried);

    }
}
