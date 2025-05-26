package com.hospitalvet.backend.controller;

import com.hospitalvet.backend.model.Pagamento;
import com.hospitalvet.backend.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @GetMapping("/agendamento/{idAgendamento}")
    public List<Pagamento> listarPorAgendamento(@PathVariable int idAgendamento) {
        return pagamentoRepository.findByIdAgendamento(idAgendamento);
    }

    @PostMapping
    public Pagamento criar(@RequestBody Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable int id) {
        pagamentoRepository.deleteById(id);
    }
}
