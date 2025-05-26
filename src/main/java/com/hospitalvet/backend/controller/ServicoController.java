package com.hospitalvet.backend.controller;

import com.hospitalvet.backend.model.Servico;
import com.hospitalvet.backend.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoRepository servicoRepository;

    @GetMapping
    public List<Servico> listarTodos() {
        return servicoRepository.findAll();
    }

    @PostMapping
    public Servico criar(@RequestBody Servico servico) {
        return servicoRepository.save(servico);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {
        servicoRepository.deleteById(id);
    }
}
