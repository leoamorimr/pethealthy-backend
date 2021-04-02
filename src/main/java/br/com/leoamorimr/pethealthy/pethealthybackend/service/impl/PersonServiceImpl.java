package br.com.leoamorimr.pethealthy.pethealthybackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.Person;
import br.com.leoamorimr.pethealthy.pethealthybackend.repository.PersonRepository;
import br.com.leoamorimr.pethealthy.pethealthybackend.repository.PetRepository;
import br.com.leoamorimr.pethealthy.pethealthybackend.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PetRepository petRepository;

    @Override
    public Person criar(Person person) {
        return this.personRepository.save(person);
    }

    @Override
    public List<Person> obterTodos() {
        return this.personRepository.findAll();
    }

}
