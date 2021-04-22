package br.com.leoamorimr.pethealthy.pethealthybackend.dto;


import br.com.leoamorimr.pethealthy.pethealthybackend.model.Person;

import java.time.LocalDate;
import java.time.Period;

public class DogDTO extends PetDTO {

    public DogDTO(Long id, String name, String color, LocalDate birthDate, Integer tipoPet, Person person) {
        super(id, name, color, birthDate, tipoPet, person);
    }

    public Integer getAge() {
        return Period.between(getBirthDate(), LocalDate.now()).getDays();
    }

}