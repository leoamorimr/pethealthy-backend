package br.com.leoamorimr.pethealthy.pethealthybackend.repository;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}