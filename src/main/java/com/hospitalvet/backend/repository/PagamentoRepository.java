package com.hospitalvet.backend.repository;

import com.hospitalvet.backend.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
    List<Pagamento> findByIdAgendamento(Integer idAgendamento);
}