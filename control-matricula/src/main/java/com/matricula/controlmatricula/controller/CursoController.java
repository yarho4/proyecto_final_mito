package com.matricula.controlmatricula.controller;

import com.matricula.controlmatricula.dto.CursoDTO;
import com.matricula.controlmatricula.dto.GenericResponse;
import com.matricula.controlmatricula.model.Curso;
import com.matricula.controlmatricula.service.ICursoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/curso")
@RequiredArgsConstructor
public class CursoController {

    private final ICursoService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<GenericResponse<CursoDTO>> readAll() throws Exception{

        List<CursoDTO> list = service.readAll().stream().map(this::converToDTO).toList() ;
        return new ResponseEntity<>(new GenericResponse<>(200, "succedss", list), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<CursoDTO>> readById(@PathVariable("id") Integer id) throws Exception{
        Curso obj = service.readById(id);
        return ResponseEntity.ok(new GenericResponse<>(200, "success", Arrays.asList(converToDTO(obj))));
    }

    @PostMapping
    public ResponseEntity<GenericResponse<CursoDTO>> save(@Valid @RequestBody CursoDTO dto) throws Exception{
        Curso obj = service.save(converToEntity(dto));
        return new ResponseEntity<>(new GenericResponse<>(200, "success", Arrays.asList(converToDTO(obj))), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<CursoDTO>> update(@Valid @RequestBody CursoDTO dto, @PathVariable("id") Integer id) throws Exception{
        dto.setIdCurso(id);
        Curso obj = service.update(converToEntity(dto), id);
        return new ResponseEntity<>(new GenericResponse<>(200, "success", Arrays.asList(converToDTO(obj))), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private Curso converToEntity(CursoDTO dto){
        return modelMapper.map(dto, Curso.class);
    }

    private CursoDTO converToDTO(Curso curso){
        return modelMapper.map(curso, CursoDTO.class);
    }
}
