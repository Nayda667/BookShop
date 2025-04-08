package com.github.nayda667.bookshop.service;

import com.github.nayda667.bookshop.comparator.OrdersAlphabeticallyComparator;
import com.github.nayda667.bookshop.comparator.OrdersByPriceComparator;
import com.github.nayda667.bookshop.object.Book;
import com.github.nayda667.bookshop.object.Library;
import com.github.nayda667.bookshop.object.Order;

import java.time.LocalDate;
import java.util.Comparator;

public class OrderService {

    private final Library library;

    public OrderService(Library library) {
        this.library = library;
    }

    public void printOrders() {
        for (Order order : library.getOrders()) {
            System.out.println("Имя " + order.getName() + " цена " + order.getPrice());
        }
        System.out.println();
    }

    public void printListOfCompletedOrders() {
        for (Order order : library.getOrders()) {
            if (order.isCompleted()) {
                System.out.println(order);
            }
        }
        System.out.println();
    }

    public void printAmountEarned() {
        int price = 0;

        for (Order order : library.getOrders()) {
            if (order.isCompleted()) {
                price = price + order.getPrice();
            }
        }

        System.out.println(price);
        System.out.println();
    }

    public void printQuantityOfCompletedOrders() {
        int i = 0;

        for (Order order : library.getOrders()) {
            if (order.isCompleted()) {
                i++;
            }
        }
        System.out.println(i + "количество выполненных заказов");
        System.out.println();
    }

    public void printListOfOrdersAlphabetically() {
        printSortedOrders(new OrdersAlphabeticallyComparator());
    }

    public void doOrderCompleted(Order order, LocalDate localDate) {
        order.setCompleted(true);
        order.setExecutionDate(localDate);
    }

    public void numberOfCompletedOrdersPerMonth() {
        int i=0;
        LocalDate date = LocalDate.now();
        for (Order order : library.getOrders()) {
            if (date.isAfter(order.getExecutionDate().plusMonths(1))) ;
            {
                i++;
            }
        }
        System.out.println(i+"количество выполненных заказов за месяц");
        System.out.println();
    }

    public void amountOfProcessedFundsPerMonth() {
        int amount=0;
        LocalDate date = LocalDate.now();
        for (Order order : library.getOrders()) {
            if (order.isCompleted()) {
                if (date.isBefore(order.getExecutionDate().plusMonths(1))) ;
                {
                    amount = order.getPrice() + amount;
                }
            }
        }
        System.out.println(amount+"количество заработаных средств за месяц");
        System.out.println();
    }

    public void printListOfOrdersByPrice() {
        printSortedOrders(new OrdersByPriceComparator());
    }

    public void printDetailsOfOrder(String name) {
        for (Order order: library.getOrders()){
            if (name.equals(order.getName())){
                for (Book book : order.getListOfBooks()) {
                    System.out.println(book);
                }
                System.out.println();
            }
        }
    }

    private void printSortedOrders(Comparator<Order> comparator) {
        library.getOrders().sort(comparator);
        printOrders();
    }
}
