package com.github.nayda667.bookshop.service;

import com.github.nayda667.bookshop.comparator.BooksAlphabeticallyComparator;
import com.github.nayda667.bookshop.comparator.BooksByAvailabilityInStockComparator;
import com.github.nayda667.bookshop.comparator.BooksByPriceComparator;
import com.github.nayda667.bookshop.object.Book;
import com.github.nayda667.bookshop.object.Library;
import com.github.nayda667.bookshop.object.Order;

import java.time.LocalDate;
import java.util.Comparator;

public class BookService {

    private final Library library;

    public BookService(Library library) {
        this.library = library;
    }

    public void printBooks() {
        for (Book book : library.getBooks()) {
            System.out.println(book);
        }
        System.out.println();
    }

    public void printListOfBooksAlphabetically() {
        printSortedBooks(new BooksAlphabeticallyComparator());
    }

    public void printListOfBookByPrice() {
        printSortedBooks(new BooksByPriceComparator());
    }

    public void printListOfOldBooks() {
        LocalDate date = LocalDate.now();
        for (Book book : library.getBooks()) {
            if (date.isAfter(book.getDate().plusMonths(6))) {
                System.out.println(book);
            }
        }
        System.out.println();
    }


    public void sortBooksByAvailabilityInStock() {
        printSortedBooks(new BooksByAvailabilityInStockComparator());
    }

    public void printDescription(Book book) {
        System.out.println(book.getDescription());
        System.out.println();
    }

    public void printBookRequestList(Book book) {
        int i = 0;

        for (Order order : library.getOrders()) {
            for (Book bookFromOrder : order.getListOfBooks()) {
                if (book.equals(bookFromOrder)) {
                    i++;
                }
            }
        }
        book.setBookRequestList(i);
        System.out.println(i + " количество запросов на книгу");
        System.out.println();
    }

    private void printSortedBooks(Comparator<Book> comparator) {
        library.getBooks().sort(comparator);
        printBooks();
    }
}
