package com.matricula.controlmatricula.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString()
public class CursoDTO {

    private Integer idCurso;

    @NotNull
    @NotBlank
    @ToString.Include
    private String nombreCurso;

    @NotNull
    @NotBlank
    private String siglasCurso;

    @NotNull
    private boolean estadoCurso;
}
