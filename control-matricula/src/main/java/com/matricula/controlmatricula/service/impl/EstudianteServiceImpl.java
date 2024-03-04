package com.matricula.controlmatricula.service.impl;

import com.matricula.controlmatricula.model.Estudiante;
import com.matricula.controlmatricula.repo.IEstudianteRepo;
import com.matricula.controlmatricula.repo.IGenericRepo;
import com.matricula.controlmatricula.service.IEstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl extends CRUDImpl<Estudiante, Integer> implements IEstudianteService {

    private final IEstudianteRepo repo;

    @Override
    protected IGenericRepo<Estudiante, Integer> getRepo() {
        return repo;
    }
}
