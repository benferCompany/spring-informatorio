package com.info.infoprimeraapp.service;

import com.info.infoprimeraapp.domain.Author;
import java.util.List;

public interface AuthorService {
    public List<Author> getAllAuthor();
    public boolean createAuthor(Author author);
    public boolean editAuthor(Author author);
    public Author searchAuthor(String name);
    public boolean deleteAuthor(Long uuid);
    
}
