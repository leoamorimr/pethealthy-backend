package br.com.leoamorimr.pethealthy.pethealthybackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.Pet;
import br.com.leoamorimr.pethealthy.pethealthybackend.repository.PetRepository;
import br.com.leoamorimr.pethealthy.pethealthybackend.service.exception.ObjectNotFoundException;

@Service
public class PetService {

	@Autowired
	private PetRepository repo;

	public List<Pet> getAll() {
		return this.repo.findAll();
	}

	public Pet getById(Long codigo) {
		return this.repo.findById(codigo).orElseThrow(() -> new ObjectNotFoundException("Pet não encontrado!"));
	}

	public List<Pet> getByPersonalName(String nome) {
		List<Pet> pets = repo.findByPersonFirstNameLastName(nome);

		if (pets.isEmpty())
			throw new ObjectNotFoundException("Nenhum Pet encontrado!");

		return pets;
	}

	public Pet insert(Pet obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public void delete(Long id) {
		Optional<Pet> pet = repo.findById(id);

		if (!pet.isPresent())
			throw new ObjectNotFoundException("Nenhum Pet encontrado!");

		repo.deleteById(id);
	}
}
