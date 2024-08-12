package io.arun.learning.controller;

import io.arun.learning.model.Book;
import io.arun.learning.service.BookService;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.micronaut.views.View;
import jakarta.inject.Inject;

import java.util.Collections;
import java.util.Map;

@Controller
public class BookViewController {

    @Inject
    private BookService bookService;

    @Get(uris =  {"/", "/books"})
    @View("list.html")
    public Map<String, Object> listBooks() {
        return Collections.singletonMap("books", bookService.findAll());
    }

    @Get("/add")
    @View("add.html")
    public Map<String, Object> addBook() {
        return Map.of("book", new Book());
    }

    @Post("/save")
    @View("list.html")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Map<String, Object> saveBook(@Body Book book) {
        bookService.add(book);
        return Collections.singletonMap("books", bookService.findAll());
    }

    @Get("/edit/{id}")
    @View("edit.html")
    public Map<String, Object> editBook(@PathVariable("id") int id) {
        Book book = bookService.findById(id).get();
        return Map.of("book", book);
    }

    @Post("/update")
    @View("list.html")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Map<String, Object> updateBook(@Body Book book) {
        bookService.update(book);
        return Collections.singletonMap("books", bookService.findAll());
    }

    @Get("/delete/{id}")
    @View("list.html")
    public Map<String, Object> deleteBook(@PathVariable("id") int id) {
        bookService.deleteById(id);
        return Collections.singletonMap("books", bookService.findAll());
    }

}
