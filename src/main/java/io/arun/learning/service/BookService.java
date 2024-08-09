package io.arun.learning.service;

import io.arun.learning.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(int id);

    Book add(Book book);

    Book update(Book book);

    void deleteById(int id);

    void deleteAll();

}
