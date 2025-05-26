package com.hospitalvet.backend.controller;

import com.hospitalvet.backend.model.Animal;
import com.hospitalvet.backend.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/animais")
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping("/usuario/{idUsuario}")
    public List<Animal> listarPorUsuario(@PathVariable Integer idUsuario) {
        return animalRepository.findByIdUsuario(idUsuario);
    }

    @PostMapping
    public Animal cadastrar(@RequestBody Animal animal) {
        return animalRepository.save(animal);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Integer id) {
        animalRepository.deleteById(id);
    }
}
