package br.com.leoamorimr.pethealthy.pethealthybackend.service.impl;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.Person;
import br.com.leoamorimr.pethealthy.pethealthybackend.repository.PersonRepository;
import br.com.leoamorimr.pethealthy.pethealthybackend.repository.PetRepository;
import br.com.leoamorimr.pethealthy.pethealthybackend.service.PersonService;
import br.com.leoamorimr.pethealthy.pethealthybackend.exception.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Person> obterPorId(Long id) {
        return this.personRepository.findById(id);
    }

    @Override
    public void deletarPorId(Long id) {
        if (!personRepository.existsById(id))
            throw new PersonNotFoundException("Pessoa com o id: " + id + " não existe!");
        this.personRepository.deleteById(id);
    }

}
