package com.enzo.fiap.reup.domain.usuario;


import com.enzo.fiap.reup.domain.matricula.Matricula;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(name = "area_atuacao", nullable = false)
    private String areaAtuacao;

    @Column(name = "nivel_carreira", nullable = false)
    @Enumerated(EnumType.STRING)
    private NivelCarreira nivelCarreira;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRoles roles;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "usuario")
    private List<Matricula> matriculas;

}
