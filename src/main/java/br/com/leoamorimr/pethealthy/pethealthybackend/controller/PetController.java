package br.com.leoamorimr.pethealthy.pethealthybackend.controller;

import br.com.leoamorimr.pethealthy.pethealthybackend.model.Pet;
import br.com.leoamorimr.pethealthy.pethealthybackend.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public List<Pet> obterTodos() {
        List<Pet> pets = petService.obterTodos();
        return pets;
    }

    @GetMapping("/{codigo}")
    public Pet obterPorCodigo(@PathVariable String codigo) {
        return this.petService.obterPorCodigo(codigo);
    }

    @GetMapping("/dono/{nome}")
    public List<Pet> obterPorNomeDono(@PathVariable(required = true)  String nome) {
        return this.petService.obterPorNomeDono(nome);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void criar(@RequestBody Pet pet) {
        this.petService.criar(pet);
    }
}
