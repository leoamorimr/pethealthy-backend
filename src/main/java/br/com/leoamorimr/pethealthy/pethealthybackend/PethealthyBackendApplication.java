package br.com.leoamorimr.pethealthy.pethealthybackend;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.Person;
import br.com.leoamorimr.pethealthy.pethealthybackend.model.Pet;
import br.com.leoamorimr.pethealthy.pethealthybackend.repository.PersonRepository;
import br.com.leoamorimr.pethealthy.pethealthybackend.repository.PetRepository;

@SpringBootApplication
public class PethealthyBackendApplication implements CommandLineRunner {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PetRepository petRepository;

    public static void main(String[] args) {
        SpringApplication.run(PethealthyBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Person person1 = new Person(null, "Leonardo", "Amorim", LocalDate.of(1989, Month.FEBRUARY, 1));
        Person person2 = new Person(null, "Renato", "Ramos", LocalDate.of(1957, Month.SEPTEMBER, 1));

        Pet p1 = new Pet(null, "Mel", "Black/Brown", LocalDate.of(2009, Month.AUGUST, 1), person1);
        Pet p2 = new Pet(null, "Kim", "Black/Brown", LocalDate.of(2009, Month.AUGUST, 1), person2);
        Pet p3 = new Pet(null, "Gaia", "White/Brown", LocalDate.of(2009, Month.AUGUST, 1), person2);

        personRepository.saveAll(Arrays.asList(person1, person2));
        petRepository.saveAll(Arrays.asList(p1, p2, p3));

    }

}
