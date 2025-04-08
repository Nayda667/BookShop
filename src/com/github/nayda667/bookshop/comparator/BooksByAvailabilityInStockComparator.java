package com.github.nayda667.bookshop.comparator;

import com.github.nayda667.bookshop.object.Book;

import java.util.Comparator;

public class BooksByAvailabilityInStockComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return Integer.compare(o1.getBookRequestList(), o2.getBookRequestList());
    }
}
