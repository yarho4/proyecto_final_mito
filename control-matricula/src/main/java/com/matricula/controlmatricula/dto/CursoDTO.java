package com.matricula.controlmatricula.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CursoDTO {

    private Integer idCurso;

    @NotNull
    @NotBlank
    private String nombreCurso;

    @NotNull
    @NotBlank
    private String siglasCurso;

    @NotNull
    private boolean estadoCurso;
}
