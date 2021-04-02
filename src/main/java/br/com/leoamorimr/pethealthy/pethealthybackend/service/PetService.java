package br.com.leoamorimr.pethealthy.pethealthybackend.service;

import java.util.List;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.Pet;

public interface PetService {

    public List<Pet> obterTodos();

    public Pet obterPorCodigo(String codigo);

    public Pet criar(Pet pet);

    public List<Pet> obterPorNomeDono(String nome);
}
