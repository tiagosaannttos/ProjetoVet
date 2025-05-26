package com.hospitalvet.backend.repository;

import com.hospitalvet.backend.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {}
