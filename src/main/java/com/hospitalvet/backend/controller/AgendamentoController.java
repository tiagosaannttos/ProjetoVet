package com.hospitalvet.backend.controller;

import com.hospitalvet.backend.model.Agendamento;
import com.hospitalvet.backend.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@CrossOrigin(origins = "*")
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @GetMapping
    public List<Agendamento> listarTodos() {
        return agendamentoRepository.findAll();
    }

    @GetMapping("/usuario/{idUsuario}")
    public List<Agendamento> listarPorUsuario(@PathVariable int idUsuario) {
        return agendamentoRepository.findByIdUsuario(idUsuario);
    }

    @PostMapping
    public Agendamento criar(@RequestBody Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {
        agendamentoRepository.deleteById(id);
    }
}
