package br.com.leoamorimr.pethealthy.pethealthybackend.service;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.Person;
import br.com.leoamorimr.pethealthy.pethealthybackend.model.Pet;
import br.com.leoamorimr.pethealthy.pethealthybackend.repository.PersonRepository;
import br.com.leoamorimr.pethealthy.pethealthybackend.repository.PetRepository;
import br.com.leoamorimr.pethealthy.pethealthybackend.service.exception.ConstraintViolationException;
import br.com.leoamorimr.pethealthy.pethealthybackend.service.exception.DataIntegrityException;
import br.com.leoamorimr.pethealthy.pethealthybackend.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    private PetRepository repo;
    @Autowired
    private PersonRepository personRepo;

    public List<Pet> findAll() {
        return repo.findAll();
    }

    public Pet find(Long id) {
        Optional<Pet> pet = repo.findById(id);
        return pet.orElseThrow(
                () -> new ObjectNotFoundException("Pet não encontrado! " + id + " Tipo:" + Pet.class.getName()));
    }

    public Pet insert(Pet obj) {
        if (!personRepo.existsById(obj.getPerson().getId()))
            throw new ObjectNotFoundException("Dono não encontrado! ");

        obj.setId(null);
        repo.save(obj);
        return obj;
    }

    public Pet update(Pet obj) {
        find(obj.getId());
        return repo.save(obj);
    }

    public void delete(Long id) {
        Pet pet = find(id);
        if (pet == null)
            throw new ObjectNotFoundException("Pet com o id: " + id + " não existe! Tipo:" + Pet.class.getName());
        repo.deleteById(id);
    }
}