package com.info.infoprimeraapp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Author {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long uuid;
    
    @Column(length = 40, columnDefinition = "varchar(40)", updatable = true, nullable = false)
    private String name;

    @Column(length = 40, columnDefinition = "varchar(40)", updatable = true, nullable = false)
    private String lastname;

    @Column(updatable = true, nullable = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date birthdate;
}
