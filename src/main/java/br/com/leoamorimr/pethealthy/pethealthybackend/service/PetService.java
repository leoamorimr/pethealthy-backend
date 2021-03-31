package br.com.leoamorimr.pethealthy.pethealthybackend.service;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.Pet;

import java.util.List;
import java.util.Optional;

public interface PetService {

    public List<Pet> obterTodos();

    public Pet obterPorCodigo(String codigo);

    public Pet criar(Pet pet);
}
