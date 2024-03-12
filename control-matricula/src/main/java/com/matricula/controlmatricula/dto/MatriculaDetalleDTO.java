package com.matricula.controlmatricula.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

//@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString(onlyExplicitlyIncluded = true)
public class MatriculaDetalleDTO {

    private Integer idMatriculaDetalle;

    @JsonBackReference
    private MatriculaDTO matricula;

    @NotNull
    private CursoDTO curso;

    @ToString.Include
    @NotNull
    private String aula;

}
