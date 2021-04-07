package br.com.leoamorimr.pethealthy.pethealthybackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.Person;

public interface PersonService {

    public Person create(Person person);

    public List<Person> getAll();

    public Optional<Person> getById(Long id);

    public void deleteById(Long id);
}
