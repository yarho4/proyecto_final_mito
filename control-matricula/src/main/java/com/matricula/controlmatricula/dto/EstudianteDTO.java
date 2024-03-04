package com.matricula.controlmatricula.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstudianteDTO {

    private Integer idEstudiante;

    @NotNull
    @NotBlank
    private String nombresEstudiante;

    @NotNull
    @NotBlank
    private String apellidosEstudiante;

    @NotNull
    private int edadEstudiante;

}
