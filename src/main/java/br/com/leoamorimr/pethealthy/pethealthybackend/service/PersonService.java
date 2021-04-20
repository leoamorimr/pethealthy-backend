package br.com.leoamorimr.pethealthy.pethealthybackend.service;

import java.util.List;
import java.util.Optional;

import br.com.leoamorimr.pethealthy.pethealthybackend.controller.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leoamorimr.pethealthy.pethealthybackend.controller.exception.PetNotFoundException;
import br.com.leoamorimr.pethealthy.pethealthybackend.model.Person;
import br.com.leoamorimr.pethealthy.pethealthybackend.repository.PersonRepository;
import br.com.leoamorimr.pethealthy.pethealthybackend.repository.PetRepository;

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
        return person.orElseThrow(()->new PersonNotFoundException("Pessoa não encontrada! "+id+" Tipo:"));
    }

    public Person insert(Person obj) {
        obj.setId(null);
        return personRepo.save(obj);
    }

    public void deleteById(Long id) {
        if (!personRepo.existsById(id))
            throw new PetNotFoundException("Pessoa com o id: " + id + " não existe!");
        this.personRepo.deleteById(id);
    }

}
