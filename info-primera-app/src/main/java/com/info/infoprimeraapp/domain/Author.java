package com.info.infoprimeraapp.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Author {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long uuid;
    
    @Column(length = 40, columnDefinition = "varchar(40)", updatable = true, nullable = false)
    private String name;

    @Column(length = 40, columnDefinition = "varchar(40)", updatable = true, nullable = false)
    private String lastname;

    @Column(updatable = true, nullable = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date birthdate;
}
