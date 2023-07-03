package com.info.infoprimeraapp.domain;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Book {

    private UUID uuid;
    private String title;
    private String author;

    public Book() {
    }

    
    public Book(UUID uuid, String title, String author) {
        this.uuid = uuid;
        this.title = title;
        this.author = author;
    }

    
    
    
    
}
