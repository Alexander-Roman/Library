/*
 * Task 6
 *
 * Разработать класс Book с 4-5 полями. Для выполнения основных операций со списком книг,
 * которые хранятся в некотором хранилище разработать класс BookDao с функциональностью:
 *
 * - addBook (добавить книгу в хранилище в случае, если такой книги нет, в противном случае выбросить исключение);
 * - removeBook (удалить книгу, если она есть, в противном случае выбросить исключение);
 * - findByTag(найти книгу по заданному критерию); (enum name, String value)
 * - Specification - List<Book> find(value)  (e.g. TitleSpecification )
 * - sortBooksByTag (отсортировать список книг по заданному критерию).
 *
 * Работу классов продемонстрировать на примере консольного приложения (без интерактивного ввода/вывода).
 * Использовать Log4j.
 */
package com.epam.library.main;

import com.epam.library.dao.BookDAO;
import com.epam.library.data.HardCodeListBookDAOProvider;
import com.epam.library.data.ListBookDAOProvider;
import com.epam.library.entity.Book;
import com.epam.library.entity.BookField;
import com.epam.library.view.BookView;
import com.epam.library.view.ConsoleBookView;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Runner {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void main(String[] args) {

        ListBookDAOProvider provider = new HardCodeListBookDAOProvider();
        BookDAO bookDAO = provider.getListBookDAO();
        BookView view = new ConsoleBookView();


        LOGGER.log(Level.INFO, "Initial list of books sorted by title:");
        List<Book> initial = bookDAO.getSorted(BookField.TITLE);
        view.printBooksList(initial);


        LOGGER.log(Level.INFO, "List of books sorted by author:");
        List<Book> sorted = bookDAO.getSorted(BookField.AUTHOR);
        view.printBooksList(sorted);


        BookField queryField = BookField.YEAR;
        LOGGER.log(Level.INFO, "Queried list of books:");
        List<Book> queried = bookDAO.query(queryField, "2017");
        view.printBooksList(queried);
    }
}
