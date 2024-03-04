package com.matricula.controlmatricula.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.matricula.controlmatricula.model.Estudiante;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatriculaDTO {

    private Integer idMatricula;

    @NotNull
    private LocalDateTime fechaMatricula;

    @NotNull
    private Estudiante estudianteMatricula;

    @NotNull
    private boolean estadoMatricula;

    @JsonManagedReference
    @NotNull
    private List<MatriculaDetalleDTO> detalles;
}
