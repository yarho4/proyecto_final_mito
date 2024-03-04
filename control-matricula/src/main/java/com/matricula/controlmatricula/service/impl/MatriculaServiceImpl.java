package com.matricula.controlmatricula.service.impl;

import com.matricula.controlmatricula.model.Curso;
import com.matricula.controlmatricula.model.Matricula;
import com.matricula.controlmatricula.repo.ICursoRepo;
import com.matricula.controlmatricula.repo.IGenericRepo;
import com.matricula.controlmatricula.repo.IMatriculaRepo;
import com.matricula.controlmatricula.service.ICursoService;
import com.matricula.controlmatricula.service.IMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MatriculaServiceImpl extends CRUDImpl<Matricula, Integer> implements IMatriculaService {

    private final IMatriculaRepo repo;

    @Override
    protected IGenericRepo<Matricula, Integer> getRepo() {
        return repo;
    }
}
