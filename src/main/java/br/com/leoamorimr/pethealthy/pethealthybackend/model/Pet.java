package br.com.leoamorimr.pethealthy.pethealthybackend.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Pet {

    @Id
    private String codigo;

    private String name;

    private String color;

    private LocalDate birthDate;

    @DBRef
    private Person owner;

}
