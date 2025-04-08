package com.github.nayda667.bookshop.comparator;

import com.github.nayda667.bookshop.object.Book;

import java.util.Comparator;

public class BooksAlphabeticallyComparator implements Comparator<Book> {

    @Override
    public int compare(Book o1, Book o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
