package com.github.nayda667.bookshop.object;

import com.ihg.loyalty.enr.stay.FileWorker;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private final FileWorker fileWorker = new FileWorker();
    private List<Book> books = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();

    public void init() {
        books.addAll(fileWorker.readFromFile(Book.class));
        orders.addAll(fileWorker.readFromFile(Order.class));
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void deleteBook(String name) {
        books.removeIf(item -> name.equals(item.getName()));
    }

    public void deleteOrder(String name) {
        orders.removeIf(item -> name.equals(item.getName()));
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Book getBookByName(String name) {
        for (Book book : books) {
            if (book.getName().equals(name)) {
                return book;
            }
        }
        return null;
    }

    public void close() {
        fileWorker.saveToFile(books, Book.class);
        fileWorker.saveToFile(orders, Order.class);
    }
}

