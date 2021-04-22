package br.com.leoamorimr.pethealthy.pethealthybackend.dto;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.Person;
import br.com.leoamorimr.pethealthy.pethealthybackend.model.Pet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PetDTO implements Serializable {

    private Long id;
    private String name;
    private String color;
    private LocalDate birthDate;
    private Integer tipoPet;
    private Person person;

    public PetDTO(Pet obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.color = obj.getColor();
        this.birthDate = obj.getBirthDate();
        this.tipoPet = obj.getTipoPet().getId();
        this.person = obj.getPerson();
    }
}