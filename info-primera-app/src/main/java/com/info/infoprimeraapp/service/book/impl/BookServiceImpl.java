package com.info.infoprimeraapp.service.book.impl;

import com.info.infoprimeraapp.domain.Book;
import com.info.infoprimeraapp.service.book.BookService;

import java.util.*;

import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    HashMap<UUID, Book> bookMap;

    public BookServiceImpl() {
        bookMap = new HashMap();

        Book book = new Book();
        book.setUuid(UUID.randomUUID());
        book.setAuthor("Gabriel Garcia Marquez");
        book.setTitle("Cien años de soledad");

        Book book2 = new Book();
        book2.setUuid(UUID.randomUUID());
        book2.setAuthor("George Orwell");
        book2.setTitle("1984");

        Book book3 = new Book();
        book3.setUuid(UUID.randomUUID());
        book3.setAuthor("Antoine de Saint-Exupery");
        book3.setTitle("principito");

        bookMap.put(book.getUuid(), book);
        bookMap.put(book2.getUuid(), book2);
        bookMap.put(book3.getUuid(), book3);
    }

    @Override
    public List<Book> getAllBooks() {

        return new ArrayList<Book>(bookMap.values());
    }

    @Override
    public Book searchBook(String title) {
        List<Book> books = new ArrayList<Book>(bookMap.values());
        Book bookEncontrado = null;
        bookEncontrado = new ArrayList<Book>(bookMap.values()).stream()
                .filter(book -> book.getTitle().equals(title))
                .findFirst()
                .orElse(null);
        return bookEncontrado;
    }

    @Override
    public Book createBook(Book book) {
        try {
            book.setUuid(UUID.randomUUID());
            bookMap.put(book.getUuid(), book);
            return book;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public boolean deleteBook(UUID uuid) {

        try {
            // Verifica si el libro existe en el HashMap
            if (bookMap.containsKey(uuid)) {
                bookMap.remove(uuid);
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
            if (bookMap.containsKey(book.getUuid())) {
                bookMap.put(book.getUuid(), book);
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
    public Optional<Book> getBookById(UUID uuid) {
        return Optional.empty();
    }

}
