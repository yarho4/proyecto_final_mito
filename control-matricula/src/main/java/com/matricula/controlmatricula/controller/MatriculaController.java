package com.matricula.controlmatricula.controller;

import com.matricula.controlmatricula.dto.GenericResponse;
import com.matricula.controlmatricula.dto.MatriculaDTO;
import com.matricula.controlmatricula.model.Matricula;
import com.matricula.controlmatricula.service.IMatriculaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/matricula")
@RequiredArgsConstructor
public class MatriculaController {

    private final IMatriculaService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<GenericResponse<MatriculaDTO>> readAll() throws Exception{

        List<MatriculaDTO> list = service.readAll().stream().map(this::converToDTO).toList() ;
        return new ResponseEntity<>(new GenericResponse<>(200, "success", list), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<MatriculaDTO>> readById(@PathVariable("id") Integer id) throws Exception{
        Matricula obj = service.readById(id);
        return ResponseEntity.ok(new GenericResponse<>(200, "success", Arrays.asList(converToDTO(obj))));
    }

    @PostMapping
    public ResponseEntity<GenericResponse<MatriculaDTO>> save(@Valid @RequestBody MatriculaDTO dto) throws Exception{
        Matricula obj = service.save(converToEntity(dto));
        return new ResponseEntity<>(new GenericResponse<>(200, "success", Arrays.asList(converToDTO(obj))), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<MatriculaDTO>> update(@Valid @RequestBody MatriculaDTO dto, @PathVariable("id") Integer id) throws Exception{
        dto.setIdMatricula(id);
        Matricula obj = service.update(converToEntity(dto), id);
        return new ResponseEntity<>(new GenericResponse<>(200, "success", Arrays.asList(converToDTO(obj))), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private Matricula converToEntity(MatriculaDTO dto){
        return modelMapper.map(dto, Matricula.class);
    }

    private MatriculaDTO converToDTO(Matricula matricula){
        return modelMapper.map(matricula, MatriculaDTO.class);
    }
}
