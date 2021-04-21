package br.com.leoamorimr.pethealthy.pethealthybackend.model;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.enums.TipoPet;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pet implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String color;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "birth_date")
    private LocalDate birthDate;


    private Integer tipoPet;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    public Pet() {
    }

    public Pet(Long id, String name, String color, LocalDate birthDate, TipoPet tipoPet, Person person) {
        super();
        this.id = id;
        this.name = name;
        this.color = color;
        this.birthDate = birthDate;
        this.person = person;
        this.tipoPet = tipoPet.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public TipoPet getTipoPet() {
        return TipoPet.toEnum(tipoPet);
    }

    public void setTipoPet(TipoPet tipoPet) {
        this.tipoPet = tipoPet.getId();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

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

}