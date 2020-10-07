package com.epam.library.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/* JavaBean Pattern with Builder */
public class Book implements Serializable {

    private static final long serialVersionUID = 7513582616386546656L;

    private long id;
    private String title;
    private Set<String> authors;
    private int year;
    private BigDecimal price;

    public Book() {
    }

    private Book(Builder builder) {
        id = builder.id;
        title = builder.title;
        authors = builder.authors;
        year = builder.year;
        price = builder.price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<String> authors) {
        this.authors = authors;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return id == book.id &&
                year == book.year &&
                Objects.equals(title, book.title) &&
                Objects.equals(authors, book.authors) &&
                Objects.equals(price, book.price);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (authors != null ? authors.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", year=" + year +
                ", price=" + price +
                '}';
    }

    public static class Builder {

        private final long id;
        private final String title;
        private final Set<String> authors = new LinkedHashSet<String>();
        private int year = 0;
        private BigDecimal price = BigDecimal.valueOf(0.00);

        public Builder(long id, String title) {
            this.id = id;
            this.title = title;
        }

        public Builder author(String author) {
            authors.add(author);
            return this;
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}
