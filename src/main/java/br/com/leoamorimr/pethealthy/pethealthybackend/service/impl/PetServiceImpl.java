package br.com.leoamorimr.pethealthy.pethealthybackend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leoamorimr.pethealthy.pethealthybackend.exception.PetNotFoundException;
import br.com.leoamorimr.pethealthy.pethealthybackend.model.Pet;
import br.com.leoamorimr.pethealthy.pethealthybackend.repository.PetRepository;
import br.com.leoamorimr.pethealthy.pethealthybackend.service.PetService;

@Service
public class PetServiceImpl implements PetService {

	@Autowired
	private PetRepository petRepository;

	@Override
	public List<Pet> getAll() {
		return this.petRepository.findAll();
	}

	@Override
	public Pet getById(Long codigo) {
		return this.petRepository.findById(codigo).orElseThrow(() -> new PetNotFoundException("Pet não encontrado!"));
	}

	@Override
	public List<Pet> getByPersonalName(String nome) {
		List<Pet> pets = petRepository.findByPersonFirstNameLastName(nome);

		if (pets.isEmpty())
			throw new PetNotFoundException("Nenhum Pet encontrado!");

		return pets;
	}

	@Override
	public Pet create(Pet pet) {
		return this.petRepository.save(pet);
	}

	@Override
	public void delete(Long id) {
		Optional<Pet> pet = petRepository.findById(id);

		if (!pet.isPresent())
			throw new PetNotFoundException("Nenhum Pet encontrado!");

		petRepository.deleteById(id);
	}
}
