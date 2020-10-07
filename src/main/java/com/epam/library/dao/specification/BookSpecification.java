package com.epam.library.dao.specification;

import com.epam.library.entity.Book;

public interface BookSpecification {

    boolean specified(Book book);
}
