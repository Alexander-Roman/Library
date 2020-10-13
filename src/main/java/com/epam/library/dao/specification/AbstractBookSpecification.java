package com.epam.library.dao.specification;

public abstract class AbstractBookSpecification implements BookSpecification {

    private final String fieldValue;

    public AbstractBookSpecification(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public String getFieldValue() {
        return fieldValue;
    }
}
