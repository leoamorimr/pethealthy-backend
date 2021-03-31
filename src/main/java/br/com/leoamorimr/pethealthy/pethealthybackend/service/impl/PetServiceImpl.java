package br.com.leoamorimr.pethealthy.pethealthybackend.service.impl;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.Pet;
import br.com.leoamorimr.pethealthy.pethealthybackend.repository.PetRepository;
import br.com.leoamorimr.pethealthy.pethealthybackend.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetRepository petRepository;

    @Override
    public List<Pet> obterTodos() {
        return this.petRepository.findAll();
    }

    @Override
    public Pet obterPorCodigo(String codigo) {
        return this.petRepository
                .findById(codigo)
                .orElseThrow(() -> new IllegalArgumentException("Pet não encontrado!"));
    }

    @Override
    public Pet criar(Pet pet) {
        return this.petRepository.save(pet);
    }
}
