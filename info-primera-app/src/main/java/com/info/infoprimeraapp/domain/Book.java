package com.info.infoprimeraapp.domain;

import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;



@Getter @Setter
@Entity
public class Book {
    
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy="org.hibernate.id.UUIDGenerator")
    @Column(length= 36,columnDefinition = "varchar(36)",updatable=false, nullable=false)
    
    private UUID uuid;
    
    @Column(length=40, columnDefinition= "varchar(40)", updatable = true, nullable = false)
    private String title;

    @Column(length=40, columnDefinition= "varchar(40)", updatable = false, nullable = false)
    private String author;

    public Book() {
    }

    
    public Book(UUID uuid, String title, String author) {
        this.uuid = uuid;
        this.title = title;
        this.author = author;
    }

    
    
    
    
}
