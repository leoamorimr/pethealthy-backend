package br.com.leoamorimr.pethealthy.pethealthybackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT p FROM Person p WHERE p.id = ?1")
    Optional<Person> findById(Long id);

}