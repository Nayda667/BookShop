package com.github.nayda667.bookshop.object;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Book implements Serializable {

    private String name;
    private String description;
    private int price;
    private LocalDate date;
    private boolean isInStock;
    private int BookRequestList;

    public Book(String name, String description, int price, LocalDate date,boolean isInStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.date = date;
        this.isInStock=isInStock;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getBookRequestList() {
        return BookRequestList;
    }

    public void setBookRequestList(int bookRequestList) {
        BookRequestList = bookRequestList;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return price == book.price && date == book.date && Objects.equals(name, book.name) && Objects.equals(description, book.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price, date);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", date=" + date +
                ", isInStock=" + isInStock +
                ", BookRequestList=" + BookRequestList +
                '}';
    }

}
