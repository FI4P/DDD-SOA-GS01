package com.enzo.fiap.reup.repository;

import com.enzo.fiap.reup.domain.matricula.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<Matricula, Long> {
}
