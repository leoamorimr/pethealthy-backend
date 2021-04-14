package br.com.leoamorimr.pethealthy.pethealthybackend.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String color;
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    /**
     * @param id
     * @param name
     * @param color
     * @param birthDate
     * @param person
     */
    public Pet(Integer id, String name, String color, LocalDate birthDate, Person person) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.birthDate = birthDate;
        this.person = person;
    }

}
