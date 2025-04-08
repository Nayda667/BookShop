package com.github.nayda667.bookshop.comparator;

import com.github.nayda667.bookshop.object.Order;

import java.util.Comparator;

public class OrdersByPriceComparator implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {
        return Integer.compare(o1.getPrice(), o2.getPrice());
    }
}
