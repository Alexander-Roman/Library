package com.epam.library.dao.specification;

import com.epam.library.entity.Book;

public abstract class AbstractBookSpecification<T> implements BookSpecification {

    private final T query;

    public AbstractBookSpecification(T query) {
        this.query = query;
    }

    public T getQuery() {
        return query;
    }
}
