package io.arun.learning.service.impl;

import io.arun.learning.model.Book;
import io.arun.learning.service.BookService;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Singleton
public class BookServiceImpl implements BookService {

    static AtomicInteger id = new AtomicInteger(0);
    static List<Book> books = new ArrayList<>();

    static {
        books.add(new Book(id.incrementAndGet(), "Java", "James Gosling", "123654789"));
        books.add(new Book(id.incrementAndGet(), "C++", "Bjarne Stroustrup", "456987123"));
        books.add(new Book(id.incrementAndGet(), "C", "Dennis Ritchie", "789654132"));
    }


    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public Optional<Book> findById(int id) {
        for(Book book: books) {
            if(book.getId() == id) {
                return Optional.of(book);
            }
        }
        return Optional.empty();
    }

    @Override
    public Book add(Book book) {
        book.setId(id.incrementAndGet());
        books.add(book);
        return book;
    }

    @Override
    public Book update(Book book) {
        for(int idx=0;idx<books.size();idx++) {
            if(books.get(idx).getId() == book.getId()) {
                books.set(idx, book);
            }
        }
        return book;
    }

    @Override
    public void deleteById(int id) {
        for(Book book: books) {
            if(book.getId() == id) {
                books.remove(book);
                return;
            }
        }
    }

    @Override
    public void deleteAll() {
        books.clear();
    }
}
