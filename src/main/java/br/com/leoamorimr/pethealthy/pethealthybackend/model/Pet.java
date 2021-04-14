package br.com.leoamorimr.pethealthy.pethealthybackend.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.enums.PetTypeEnum;
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
    private Integer type;

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
    public Pet(Integer id, String name, String color, LocalDate birthDate, PetTypeEnum type, Person person) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.birthDate = birthDate;
        this.person = person;
        this.type = type.getId();
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pet other = (Pet) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    public void setType(PetTypeEnum type) {
        this.type = type.getId();
    }

    public PetTypeEnum getType() {
        return PetTypeEnum.toEnum(type);
    }

}
