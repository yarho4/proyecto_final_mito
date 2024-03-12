package com.matricula.controlmatricula.service.impl;

import com.matricula.controlmatricula.model.Estudiante;
import com.matricula.controlmatricula.repo.IEstudianteRepo;
import com.matricula.controlmatricula.repo.IGenericRepo;
import com.matricula.controlmatricula.service.IEstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Comparator.comparing;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl extends CRUDImpl<Estudiante, Integer> implements IEstudianteService {

    private final IEstudianteRepo repo;

    @Override
    protected IGenericRepo<Estudiante, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Estudiante> getNombresApellidos(String nombres, String apellidos) {
        return repo.getNombresApellidos(nombres, apellidos);
    }

    @Override
    public Estudiante getEstudianteMaxEdad() {
        return repo.findAll()
                .stream()
                .max(comparing(Estudiante::getEdad))
                .orElse(new Estudiante());
    }

    @Override
    public List<Estudiante> getEstudiantesPorEdad() {
        return repo.findAll()
                .stream()
                .sorted(comparing(Estudiante::getEdad).reversed())
                .toList();
    }


}
