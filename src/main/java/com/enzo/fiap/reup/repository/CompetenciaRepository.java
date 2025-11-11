package com.enzo.fiap.reup.repository;

import com.enzo.fiap.reup.domain.competencia.Competencia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CompetenciaRepository extends JpaRepository<Competencia, Long> {
    List<Competencia> findByNomeIn(Collection<String> nomes);
    Optional<Competencia> findByNome(String nome);
}
