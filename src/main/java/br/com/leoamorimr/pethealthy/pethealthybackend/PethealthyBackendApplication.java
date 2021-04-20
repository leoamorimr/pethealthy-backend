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
import br.com.leoamorimr.pethealthy.pethealthybackend.model.enums.TipoPet;
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

		Person person1 = new Person(null, "Leonardo", "Ramos", LocalDate.of(1989, Month.FEBRUARY, 1));
		Person person2 = new Person(null, "Renato", "Ramos", LocalDate.of(1957, Month.AUGUST, 8));

		Pet pet1 = new Pet(null, "Mel", "Preto/Marrom", LocalDate.of(2009, Month.FEBRUARY, 1), TipoPet.DOG, person1);
		Pet pet2 = new Pet(null, "Gaia", "Caramelo", LocalDate.of(2015, Month.MAY, 1), TipoPet.DOG, person2);
		Pet pet3 = new Pet(null, "Kim", "Preto/Marrom", LocalDate.of(2020, Month.JULY, 1), TipoPet.DOG, person2);
		Pet pet4 = new Pet(null, "Lili", "Preto/Branco", LocalDate.of(2020, Month.JULY, 1), TipoPet.CAT, person2);

		personRepository.saveAll(Arrays.asList(person1, person2));
		petRepository.saveAll(Arrays.asList(pet1, pet2, pet3, pet4));

	}
}
