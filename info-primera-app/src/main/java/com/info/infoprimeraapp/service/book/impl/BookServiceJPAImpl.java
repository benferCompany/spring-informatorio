package com.info.infoprimeraapp.service.book.impl;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.repository.book.BookRepository;
import com.info.infoprimeraapp.service.book.BookService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;


@Primary
@Service
@AllArgsConstructor
public class BookServiceJPAImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book searchBook(String title) {
        List<Book> books = bookRepository.findAll();
        Book bookEncontrado = null;
        bookEncontrado = books.stream()
                .filter(book -> book.getTitle().equals(title))
                .findFirst()
                .orElse(null);
        return bookEncontrado;
    }

    @Override
    public Book createBook(Book book) {
        try {
            book.setUuid(UUID.randomUUID());

            return bookRepository.save(book);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public boolean deleteBook(UUID uuid) {
        try {
            // Verifica si el libro existe en el HashMap
            if (bookRepository.existsById(uuid)) {
                bookRepository.deleteById(uuid);
                return true;
            } else {
                return false; // El libro no existe
            }
        } catch (Exception e) {
            // Manejo de excepciones en caso de error
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateBook(Book book) {
        try {
            // Verifica si el libro existe en el HashMap
            if (bookRepository.existsById(book.getUuid())) {
                bookRepository.save(book);
                return true;
            } else {
                return false; // El libro no existe
            }
        } catch (Exception e) {
            // Manejo de excepciones en caso de error
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public Optional<Book> getBookById(UUID uuid){
        return Optional.of(bookRepository.findById(uuid).orElse(null));
    }



}
