package com.info.infoprimeraapp.service;

import com.info.infoprimeraapp.domain.Author;
import java.util.List;
import java.util.UUID;

public interface AuthorService {
    public List<Author> getAllAuthor();
    public boolean createAuthor(Author author);
    public boolean editAuthor(Author author);
    public Author searchAuthor(String name);
    public boolean deleteAuthor(UUID uuid);
    
}
