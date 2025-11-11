package com.enzo.fiap.reup.domain.trilha;


import com.enzo.fiap.reup.domain.competencia.Competencia;
import com.enzo.fiap.reup.domain.matricula.Matricula;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "trilhas")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Trilha {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Nivel nivel;

    @Column(nullable = false, name = "carga_horaria")
    private int cargaHoraria;

    @Column(nullable = false, name = "foco_principal")
    private String focoPrincipal;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @CreationTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "trilha")
    private List<Matricula> matriculas;

    @ManyToMany
    @JoinTable(name = "trilha_competencia", joinColumns = @JoinColumn(name = "trilha_id"), inverseJoinColumns = @JoinColumn(name = "competencia_id"))
    private List<Competencia> competencias;




}
