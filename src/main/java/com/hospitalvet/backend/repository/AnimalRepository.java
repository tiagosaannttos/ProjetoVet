package com.hospitalvet.backend.repository;

import com.hospitalvet.backend.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> findByIdUsuario(Integer idUsuario);
}
