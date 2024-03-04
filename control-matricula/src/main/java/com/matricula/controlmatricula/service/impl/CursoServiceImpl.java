package com.matricula.controlmatricula.service.impl;

import com.matricula.controlmatricula.model.Curso;
import com.matricula.controlmatricula.repo.ICursoRepo;
import com.matricula.controlmatricula.repo.IGenericRepo;
import com.matricula.controlmatricula.service.ICursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl extends CRUDImpl<Curso, Integer> implements ICursoService {

    private final ICursoRepo repo;

    @Override
    protected IGenericRepo<Curso, Integer> getRepo() {
        return repo;
    }
}
