package com.github.nayda667.bookshop;

import com.github.nayda667.bookshop.object.Book;
import com.github.nayda667.bookshop.object.Library;
import com.github.nayda667.bookshop.object.Order;
import com.github.nayda667.bookshop.service.BookService;
import com.github.nayda667.bookshop.service.OrderService;
import com.ihg.loyalty.enr.stay.FileWorker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        BookService bookService = new BookService(library);
        OrderService orderService = new OrderService(library);
        library.init();
        library.addBook(new Book("A", "u", 6, LocalDate.of(2000, 12, 3), false));
        library.addBook(new Book("B", "u", 6, LocalDate.of(2000, 12, 3), false));
        library.addBook(new Book("C", "u", 6, LocalDate.of(2000, 12, 3), false));
        library.addBook(new Book("Q", "u", 6, LocalDate.of(2000, 12, 3), false));

        library.addBook(new Book("D", "u", 6, LocalDate.of(2000, 12, 3), false));
        bookService.printBooks();
        library.deleteBook("D");
        bookService.printBooks();

        List<Book> booksInOrder1 = new ArrayList<>();
        booksInOrder1.add(library.getBookByName("A"));
        booksInOrder1.add(library.getBookByName("B"));
        Order order1 = new Order("A", booksInOrder1);

        List<Book> booksInOrder2 = new ArrayList<>();
        booksInOrder2.add(library.getBookByName("C"));
        booksInOrder2.add(library.getBookByName("B"));
        Order order2 = new Order("B", booksInOrder1);

        library.addOrder(order1);
        library.addOrder(order2);

        bookService.printListOfBookByPrice();

        bookService.printListOfBooksAlphabetically();

        bookService.printListOfOldBooks();

        bookService.sortBooksByAvailabilityInStock();

        library.deleteBook("D");

        bookService.printBooks();

        orderService.printDetailsOfOrder("A");

        orderService.printOrders();

        orderService.printAmountEarned();

        orderService.doOrderCompleted(order1, LocalDate.of(2, 1, 23));

        orderService.printQuantityOfCompletedOrders();

        orderService.printListOfCompletedOrders();

        orderService.printAmountEarned();

        orderService.amountOfProcessedFundsPerMonth();

        orderService.printListOfOrdersAlphabetically();

        orderService.printListOfOrdersByPrice();

        FileWorker fileWorker = new FileWorker();
        fileWorker.saveToFile(library.getBooks(), Book.class);
        library.close();
    }
}
