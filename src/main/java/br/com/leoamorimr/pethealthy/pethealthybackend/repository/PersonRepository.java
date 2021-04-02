package br.com.leoamorimr.pethealthy.pethealthybackend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.Person;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {

   List<Person> findByName(String name);

}