
package br.com.leoamorimr.pethealthy.pethealthybackend.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Person {

    @Id
    private String codigo;

    private String name;

    private LocalDate birthDate;

//    private List<Pet> pets;

}
