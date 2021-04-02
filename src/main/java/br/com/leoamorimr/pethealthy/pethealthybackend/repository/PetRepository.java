package br.com.leoamorimr.pethealthy.pethealthybackend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.Person;
import br.com.leoamorimr.pethealthy.pethealthybackend.model.Pet;

@Repository
public interface PetRepository extends MongoRepository<Pet, String> {

    List<Pet> findByOwner(Person owner);
}
