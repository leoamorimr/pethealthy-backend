package br.com.leoamorimr.pethealthy.pethealthybackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leoamorimr.pethealthy.pethealthybackend.exception.ObjectNotFoundException;
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
    public Person create(Person person) {
        return this.personRepository.save(person);
    }

    @Override
    public List<Person> getAll() {
        return this.personRepository.findAll();
    }

    @Override
    public Optional<Person> getById(Long id) {
        return this.personRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        if (!personRepository.existsById(id))
            throw new ObjectNotFoundException("Pessoa com o id: " + id + " não existe!");
        this.personRepository.deleteById(id);
    }

}
