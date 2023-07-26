package com.info.infoprimeraapp.controller;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.exceptions.NotFoundException;
import com.info.infoprimeraapp.service.book.BookService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/api/v1/book")
    public ResponseEntity createBook(@RequestBody Book book) {
        Book bookResponse = bookService.createBook(book);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/book/"+bookResponse.getUuid());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/api/v1/delete-book/{uuid}")
    public ResponseEntity deleteBook(@PathVariable("uuid") UUID uuid) throws NotFoundException {

        boolean deleted = bookService.deleteBook(uuid);

        if (deleted) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } else {
            throw new NotFoundException();
        }
    }

    @PutMapping("/api/v1/update-book")
    public ResponseEntity updateBook(@RequestBody Book book) throws NotFoundException {
        boolean update = bookService.updateBook(book);
        if (update) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }else{
            throw new NotFoundException();
        }

    }

    @GetMapping("/api/v1/book/{idBook}")
    public Book getBookById(@PathVariable(value = "idBook") UUID idBook) throws NotFoundException {
        return bookService.getBookById(idBook).orElseThrow(NotFoundException::new);
    }

}
