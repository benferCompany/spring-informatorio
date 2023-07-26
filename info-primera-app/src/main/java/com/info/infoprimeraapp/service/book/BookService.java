package com.info.infoprimeraapp.service.book;

import com.info.infoprimeraapp.domain.Book;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookService {

    public List<Book> getAllBooks();
    public Book searchBook(String title);
    public Book createBook(Book book);
    public boolean deleteBook(UUID uuid);
    public boolean updateBook(Book book);
    public Optional<Book> getBookById(UUID uuid);
    
}
