package com.matricula.controlmatricula.service.impl;

import com.matricula.controlmatricula.model.Matricula;
import com.matricula.controlmatricula.model.MatriculaDetalle;
import com.matricula.controlmatricula.repo.IGenericRepo;
import com.matricula.controlmatricula.repo.IMatriculaRepo;
import com.matricula.controlmatricula.service.IMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class MatriculaServiceImpl extends CRUDImpl<Matricula, Integer> implements IMatriculaService {

    private final IMatriculaRepo repo;

    @Override
    protected IGenericRepo<Matricula, Integer> getRepo() {
        return repo;
    }

    @Override
    public Map<String, List<String>> getMatriculaCursosEstudiantes() {
        Stream<Matricula> matriculaStream = repo.findAll().stream();
        Stream<List<MatriculaDetalle>> lsStream = matriculaStream.map(Matricula::getDetalles);

        Stream<MatriculaDetalle> streamDetalle = lsStream.flatMap(Collection::stream);

        Map<String, List<String>> byCurso =streamDetalle
                .collect(Collectors.groupingBy(d -> d.getCurso().getNombre(),
                        Collectors.mapping(d -> d.getMatricula().getEstudiante().getNombres(), Collectors.toList())));

        System.out.println(byCurso);

        return byCurso;

    }

    }
