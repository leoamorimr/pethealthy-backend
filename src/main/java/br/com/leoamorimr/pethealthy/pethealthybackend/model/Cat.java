package br.com.leoamorimr.pethealthy.pethealthybackend.model;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.enums.TipoPet;

import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Cat extends Pet {
    private static final long serialVersionUID = 1L;

    public Cat() {
    }

    public Cat(Long id, String name, String color, LocalDate birthDate, TipoPet tipoPet, Person person) {
        super(id, name, color, birthDate, tipoPet, person);
    }

    public Integer getAge() {
        return Period.between(getBirthDate(), LocalDate.now()).getDays();
    }

}