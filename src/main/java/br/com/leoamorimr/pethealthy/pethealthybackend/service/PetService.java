package br.com.leoamorimr.pethealthy.pethealthybackend.service;

import java.util.List;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.Pet;

public interface PetService {

    public List<Pet> getAll();

    public Pet getById(Long id);

    public Pet create(Pet pet);

    public List<Pet> getByPersonalName(String nome);

    public void delete(Long id);

}
