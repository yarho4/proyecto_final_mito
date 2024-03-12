package com.matricula.controlmatricula.service;

import com.matricula.controlmatricula.model.Matricula;

import java.util.List;
import java.util.Map;

public interface IMatriculaService extends ICRUD<Matricula, Integer> {

    Map<String, List<String>> getMatriculaCursosEstudiantes();
}
