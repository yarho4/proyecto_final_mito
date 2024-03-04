package com.matricula.controlmatricula.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class MatriculaDetalle {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMatriculaDetalle;

    @ManyToOne
    @JoinColumn(name = "id_matricula", nullable = false, foreignKey = @ForeignKey(name = "FX_MATRICULA_MAT_DETALLE"))
    private Matricula matricula;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false, foreignKey = @ForeignKey(name = "FX_MAT_DETALLE_CURSO"))
    private Curso curso;

    @Column(nullable = false, length = 30)
    private String aula;
}
