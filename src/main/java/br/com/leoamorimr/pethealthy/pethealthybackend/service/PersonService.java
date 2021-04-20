package br.com.leoamorimr.pethealthy.pethealthybackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.com.leoamorimr.pethealthy.pethealthybackend.dto.PersonDTO;
import br.com.leoamorimr.pethealthy.pethealthybackend.model.Person;
import br.com.leoamorimr.pethealthy.pethealthybackend.repository.PersonRepository;
import br.com.leoamorimr.pethealthy.pethealthybackend.repository.PetRepository;
import br.com.leoamorimr.pethealthy.pethealthybackend.service.exception.DataIntegrityException;
import br.com.leoamorimr.pethealthy.pethealthybackend.service.exception.ObjectNotFoundException;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepo;

	@Autowired
	PetRepository petRepo;

	public List<Person> findAll() {
		return personRepo.findAll();
	}

	public Person find(Long id) {
		Optional<Person> person = personRepo.findById(id);
		return person.orElseThrow(
				() -> new ObjectNotFoundException("Pessoa não encontrada! " + id + " Tipo:" + Person.class.getName()));
	}

	public Person insert(Person obj) {
		obj.setId(null);
		return personRepo.save(obj);
	}

	public Person update(Person obj) {
		find(obj.getId());
		return personRepo.save(obj);
	}

	public void delete(Long id) {
		Person person = find(id);
		if (person == null)
			throw new ObjectNotFoundException("Pessoa com o id: " + id + " não existe! Tipo:" + Person.class.getName());

		try {
			personRepo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível remover uma Pessoa com um Pet associado!");
		}

	}

	public Person fromDTO(PersonDTO objDTO) {
		return new Person(objDTO.getId(), objDTO.getFirstName(), objDTO.getLastName(), objDTO.getBirthDate());
	}
}
