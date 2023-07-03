package com.info.infoprimeraapp.controller;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.service.BookService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;

    }

    @GetMapping("/api/v1/book")
    public List<Book> getAllBooks() {

        return bookService.getAllBooks();
    }

    @GetMapping("/api/v1/search-book")
    public Book searchBook(@RequestParam("title") String title) {

        return bookService.searchBook(title);

    }

    @PostMapping("/api/v1/create-book")
    public Book createBook(@RequestBody Book book) {
        bookService.createBook(book);
        
        return book;
    }

    @DeleteMapping("/api/v1/delete-book/{uuid}")
    public String deleteBook(@PathVariable("uuid") UUID uuid) {

        boolean deleted = bookService.deleteBook(uuid);

        if (deleted) {
            return "Libro eliminado correctamente";
        } else {
            return "no se encontro";
        }
    }

    @PutMapping("/api/v1/update-book")
    public String updateBook(@RequestBody Book book) {
        boolean update = bookService.updateBook(book);
        if (update) {
            return "Exitoso.";
        }else{
            return "Algo salio mal.";
        }

    }

}
