package com.matricula.controlmatricula.service;

import com.matricula.controlmatricula.model.Estudiante;

import java.util.List;

public interface IEstudianteService extends ICRUD<Estudiante, Integer> {

    List<Estudiante> getNombresApellidos(String nombres, String apellidos);

    Estudiante getEstudianteMaxEdad();

    List<Estudiante> getEstudiantesPorEdad();

}
