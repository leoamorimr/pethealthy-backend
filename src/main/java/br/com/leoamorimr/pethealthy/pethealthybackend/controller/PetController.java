package br.com.leoamorimr.pethealthy.pethealthybackend.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.Pet;
import br.com.leoamorimr.pethealthy.pethealthybackend.service.PetService;

@RestController
@RequestMapping("/pet")
public class  PetController {

	@Autowired
	private PetService service;

	@GetMapping
	public List<Pet> obterTodos() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pet> getById(@PathVariable Long id) {
		return new ResponseEntity<Pet>(service.getById(id), HttpStatus.OK);
	}

	@GetMapping("/person/{nome}")
	public List<Pet> getByPersonName(@PathVariable String nome) {
		return this.service.getByPersonalName(nome);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> criar(@RequestBody Pet obj) {
		obj = service.insert(obj);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
}
