package com.info.infoprimeraapp.service;

import com.info.infoprimeraapp.domain.Book;
import java.util.List;
import java.util.UUID;

public interface BookService {

    public List<Book> getAllBooks();
    public Book searchBook(String title);
    public boolean createBook(Book book);
    public boolean deleteBook(UUID uuid);
    public boolean updateBook(Book book);
    
}
