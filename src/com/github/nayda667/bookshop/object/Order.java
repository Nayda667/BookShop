package com.github.nayda667.bookshop.object;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private String name;
    private List<Book> listOfBooks = new ArrayList<>();
    private boolean isCompleted;
    private LocalDate executionDate;

    public Order(String name, List<Book> list) {
        this.name = name;
        this.listOfBooks = list;
        isCompleted = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getListOfBooks() {
        return listOfBooks;
    }

    public void setListOfBooks(List<Book> listOfBooks) {
        this.listOfBooks = listOfBooks;
    }

    public int getPrice() {
        int result = 0;
        for (Book book : listOfBooks) {
            result += book.getPrice();
        }
        return result;
    }

    public LocalDate getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(LocalDate executionDate) {
        this.executionDate = executionDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", list=" + listOfBooks +
                ", price=" + getPrice() +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
