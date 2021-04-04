package br.com.leoamorimr.pethealthy.pethealthybackend.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String color;

    private LocalDate birthDate;

    @ManyToOne
    private Person person;

}
