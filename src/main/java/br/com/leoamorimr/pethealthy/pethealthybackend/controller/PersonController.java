package br.com.leoamorimr.pethealthy.pethealthybackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.Person;
import br.com.leoamorimr.pethealthy.pethealthybackend.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;

	@GetMapping
	public List<Person> getAll() {
		return personService.getAll();
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void criar(@RequestBody Person person) {
		this.personService.create(person);
	}

	@GetMapping("/{id}")
	public Person getById(@PathVariable Long id) {
		return this.personService.getById(id).orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada!"));
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		this.personService.deleteById(id);
	}

}
