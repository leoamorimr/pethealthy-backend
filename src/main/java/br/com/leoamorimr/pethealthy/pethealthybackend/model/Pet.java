package br.com.leoamorimr.pethealthy.pethealthybackend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document
public class Pet {

    @Id
    private String codigo;

    private String name;

    private String color;

    private LocalDate birthDate;

    public Pet(String codigo, String name, String color, LocalDate birthDate) {
        this.codigo = codigo;
        this.name = name;
        this.color = color;
        this.birthDate = birthDate;
    }
}
