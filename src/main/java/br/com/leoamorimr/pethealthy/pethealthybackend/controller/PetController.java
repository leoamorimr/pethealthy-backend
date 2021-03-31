package br.com.leoamorimr.pethealthy.pethealthybackend.controller;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.Pet;
import br.com.leoamorimr.pethealthy.pethealthybackend.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public List<Pet> obterTodos() {
        return petService.obterTodos();
    }

    @GetMapping("/{codigo}")
    public Pet obterPorCodigo(@PathVariable String codigo) {
        return this.petService.obterPorCodigo(codigo);
    }

    @PostMapping
    public void criar(@RequestBody Pet pet) {
        this.petService.criar(pet);
    }
}
