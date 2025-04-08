package com.github.nayda667.bookshop.comparator;

import com.github.nayda667.bookshop.object.Order;

import java.util.Comparator;

public class OrdersAlphabeticallyComparator implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
