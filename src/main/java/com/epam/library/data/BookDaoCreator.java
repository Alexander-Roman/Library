package com.epam.library.data;

import com.epam.library.dao.BookDao;

public interface BookDaoCreator {

    BookDao createBookDao();
}
