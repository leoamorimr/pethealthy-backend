package br.com.leoamorimr.pethealthy.pethealthybackend.controller;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.Person;
import br.com.leoamorimr.pethealthy.pethealthybackend.model.Pet;
import br.com.leoamorimr.pethealthy.pethealthybackend.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> obterTodos() {
        return personService.obterTodos();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void criar(@RequestBody Person person) {
        this.personService.criar(person);
    }

    @GetMapping("/{id}")
    public Person obterPorId(@PathVariable Long id) {
        return this.personService.obterPorId(id).orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada!"));
    }

    @DeleteMapping("/{id}")
    public void deletarPorId(@PathVariable Long id) {
        this.personService.deletarPorId(id);
    }

}
