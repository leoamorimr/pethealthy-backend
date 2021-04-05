package br.com.leoamorimr.pethealthy.pethealthybackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.Pet;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    @Query(value = "SELECT p FROM Pet p INNER JOIN Person pe ON(p.person.id = pe.id) WHERE (pe.first_name LIKE %?1% OR pe.last_name LIKE %?1%)")
    List<Pet> findByOwnerFirstName(String first_name);


}
