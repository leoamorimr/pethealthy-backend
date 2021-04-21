package br.com.leoamorimr.pethealthy.pethealthybackend.model;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.enums.TipoPet;

import java.time.LocalDate;
import java.time.Period;

public class Cat extends Pet {
    public Cat() {
    }

    public Cat(Long id, String name, String color, LocalDate birthDate, TipoPet tipoPet, Person person) {
        super(id, name, color, birthDate, tipoPet, person);
    }

    public Integer getAge() {
        return Period.between(LocalDate.now(), getBirthDate()).getDays();
    }

}

