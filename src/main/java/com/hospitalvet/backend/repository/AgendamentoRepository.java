package com.hospitalvet.backend.repository;

import com.hospitalvet.backend.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
    List<Agendamento> findByIdUsuario(Integer idUsuario);
}