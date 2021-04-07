package br.com.leoamorimr.pethealthy.pethealthybackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.Pet;
import br.com.leoamorimr.pethealthy.pethealthybackend.service.PetService;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public List<Pet> obterTodos() {
        return petService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pet> getById(@PathVariable Long id) {
        return new ResponseEntity<Pet>(petService.getById(id), HttpStatus.OK);
    }

    @GetMapping("/person/{nome}")
    public List<Pet> getByPersonName(@PathVariable String nome) {
        return this.petService.getByPersonalName(nome);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void criar(@RequestBody Pet pet) {
        this.petService.create(pet);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        petService.delete(id);
    }
}
