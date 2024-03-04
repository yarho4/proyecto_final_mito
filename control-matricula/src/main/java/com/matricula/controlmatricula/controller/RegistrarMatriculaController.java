package com.matricula.controlmatricula.controller;

import com.matricula.controlmatricula.service.ICursoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registrarMatricula")
@RequiredArgsConstructor
public class RegistrarMatriculaController {

    private final ICursoService service;
    private final ModelMapper modelMapper;


}
