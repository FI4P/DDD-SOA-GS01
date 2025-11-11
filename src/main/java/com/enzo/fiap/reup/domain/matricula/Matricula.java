package com.enzo.fiap.reup.domain.matricula;


import com.enzo.fiap.reup.domain.trilha.Trilha;
import com.enzo.fiap.reup.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "matriculas")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "trilha_id")
    private Trilha trilha;

    @Column(name = "data_inscricao")
    @CreationTimestamp
    private LocalDateTime dataInscricao;

}
