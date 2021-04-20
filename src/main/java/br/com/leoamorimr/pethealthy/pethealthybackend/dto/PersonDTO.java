package br.com.leoamorimr.pethealthy.pethealthybackend.dto;

import java.io.Serializable;
import java.time.LocalDate;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.Person;

public class PersonDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String firstName;

	private String lastName;

	private LocalDate birthDate;

	public PersonDTO() {
	}

	public PersonDTO(Person person) {
		this.id = person.getId();
		this.firstName = person.getFirstName();
		this.lastName = person.getLastName();
		this.birthDate = person.getBirthDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

}
