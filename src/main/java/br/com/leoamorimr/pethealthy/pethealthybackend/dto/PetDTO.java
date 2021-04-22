package br.com.leoamorimr.pethealthy.pethealthybackend.dto;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.Person;
import br.com.leoamorimr.pethealthy.pethealthybackend.model.Pet;
import br.com.leoamorimr.pethealthy.pethealthybackend.model.enums.TipoPet;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PetDTO implements Serializable {

    private Long id;

    @NotEmpty(message = "Campo obrigatório!")
    private String name;
    @NotEmpty(message = "Campo obrigatório!")
    private String color;
    private LocalDate birthDate;
    private TipoPet tipoPet;
    @NotEmpty(message = "Campo obrigatório!")
    private Person person;

    public PetDTO(Pet obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.color = obj.getColor();
        this.birthDate = obj.getBirthDate();
        this.tipoPet = obj.getTipoPet();
        this.person = obj.getPerson();
    }
}