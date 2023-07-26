package com.info.infoprimeraapp.service.book.impl;

import com.info.infoprimeraapp.domain.Author;
import com.info.infoprimeraapp.repository.book.AuthorRepository;
import com.info.infoprimeraapp.service.AuthorService;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorServiceJPAImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    @Override
    public boolean createAuthor(Author author) {

        try {
           
            authorRepository.save(author);
            return true;

        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean editAuthor(Author author) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Author searchAuthor(String name) {

        return authorRepository.findFirstByNameOrLastname(name, name);

    }

    @Override
    public boolean deleteAuthor(UUID uuid) {
        try {
            // Verifica si el libro existe en el HashMap
            if (authorRepository.existsById(uuid)) {
                authorRepository.deleteById(uuid);
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
   

}
