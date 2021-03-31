package br.com.leoamorimr.pethealthy.pethealthybackend.repository;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PetRepository extends MongoRepository<Pet,String> {
}
