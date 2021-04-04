package br.com.leoamorimr.pethealthy.pethealthybackend.service.impl;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.Person;
import br.com.leoamorimr.pethealthy.pethealthybackend.model.Pet;
import br.com.leoamorimr.pethealthy.pethealthybackend.repository.PersonRepository;
import br.com.leoamorimr.pethealthy.pethealthybackend.repository.PetRepository;
import br.com.leoamorimr.pethealthy.pethealthybackend.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Pet> obterTodos() {
        return this.petRepository.findAll();
    }

    @Override
    public Pet obterPorId(Long codigo) {
        return this.petRepository.findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Pet não encontrado!"));
    }

    @Override
    public List<Pet> obterPorNomeDono(String nome) {
////        List<Person> persons = personRepository.findByName(nome);
//
//        if (persons.isEmpty())
//            throw new IllegalStateException("Dono não Encontrado!");
//
//        List<Pet> pets = petRepository.findByPerson(persons.get(0));
//
//        if (pets.isEmpty())
//            throw new IllegalStateException("Nenhum Pet encontrado!");

        return null;
    }

    @Override
    public Pet criar(Pet pet) {
        return this.petRepository.save(pet);
    }

    @Override
    public void delete(Long id) {
        petRepository.deleteById(id);
    }
}
