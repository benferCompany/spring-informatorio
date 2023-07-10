package com.info.infoprimeraapp.controller;

import com.info.infoprimeraapp.domain.Author;
import com.info.infoprimeraapp.service.AuthorService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {
    AuthorService authorService;
    
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }
    
    @GetMapping
    public List<Author> getAllAuthor(){
        return authorService.getAllAuthor(); 
    }
    
    @PostMapping
    public Author createAuthor(@RequestBody Author author){
        
        if(authorService.createAuthor(author)){
            System.out.println("fue un exigo");
        }else{
            System.out.println("hubo un problema");
        }
        return author;
    }
    
    @GetMapping("/{name}")
    public Author searchAuthor(@PathVariable("name") String name){
        return authorService.searchAuthor(name);
    }
    
    @DeleteMapping("/{uuid}")
    public String deleteAuthor(@PathVariable("uuid") UUID uuid) {

        boolean deleted = authorService.deleteAuthor(uuid);

        if (deleted) {
            return "Libro eliminado correctamente";
        } else {
            return "no se encontro";
        }
    }
    
    
    
}
