package io.arun.learning.controller;

import io.arun.learning.model.Book;
import io.arun.learning.service.BookService;
import io.micronaut.http.annotation.*;
import jakarta.inject.Inject;

import java.util.List;

@Controller("/api")
public class BookAPIController {

    @Inject
    private BookService bookService;

    @Get("/books")
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @Post("/books")
    public Book addBook(@Body Book book) {
        return bookService.add(book);
    }

    @Put("/books")
    public Book updateBook(@Body Book book) {
        return bookService.update(book);
    }

    @Get("/books/{id}")
    public Book getBookById(@PathVariable("id") int id) {
        return bookService.findById(id).get();
    }

    @Delete("/books/{id}")
    public String deleteBookById(@PathVariable("id") int id) {
        bookService.deleteById(id);
        return "Success";
    }

    @Delete("/books")
    public String deleteAllBooks() {
        bookService.deleteAll();
        return "Success";
    }
}
