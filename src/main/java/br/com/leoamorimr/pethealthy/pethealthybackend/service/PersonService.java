package br.com.leoamorimr.pethealthy.pethealthybackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.Person;

public interface PersonService {

    public Person criar(Person person);

    public List<Person> obterTodos();

    public Optional<Person> obterPorId(Long id);

    public void deletarPorId(Long id);
}
