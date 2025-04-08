package com.github.nayda667.bookshop.comparator;

import com.github.nayda667.bookshop.object.Book;

import java.util.Comparator;

public class BooksByPriceComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return Integer.compare(o1.getPrice(), o2.getPrice());
    }
}
