package com.hospitalvet.backend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hospitalvet.backend.model.Agendamento;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Integer> {
    List<Agendamento> findByUsuarioId(Integer idUsuario); // ou int, se for o tipo correto
}
