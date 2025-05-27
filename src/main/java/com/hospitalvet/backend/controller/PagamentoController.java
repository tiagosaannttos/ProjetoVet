package com.hospitalvet.backend.controller;

import com.hospitalvet.backend.model.Pagamento;
import com.hospitalvet.backend.model.Agendamento;
import com.hospitalvet.backend.repository.PagamentoRepository;
import com.hospitalvet.backend.repository.AgendamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @GetMapping("/agendamento/{idAgendamento}")
    public List<Pagamento> listarPorAgendamento(@PathVariable Integer idAgendamento) {
        return pagamentoRepository.findByAgendamentoId(idAgendamento);
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody Pagamento pagamento) {
        if (pagamento.getAgendamento() == null || pagamento.getAgendamento().getId() == null) {
            return ResponseEntity.badRequest().body("Agendamento inválido.");
        }

        Integer idAgendamento = pagamento.getAgendamento().getId();
        Agendamento agendamentoExistente = agendamentoRepository.findById(idAgendamento).orElse(null);

        if (agendamentoExistente == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agendamento com ID " + idAgendamento + " não encontrado.");
        }

        pagamento.setAgendamento(agendamentoExistente);

        Pagamento salvo = pagamentoRepository.save(pagamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id) {
        if (!pagamentoRepository.existsById(id)) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pagamento com ID " + id + " não encontrado.");
        }

        pagamentoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
