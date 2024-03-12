package com.matricula.controlmatricula.controller;

import com.matricula.controlmatricula.dto.EstudianteDTO;
import com.matricula.controlmatricula.dto.GenericResponse;
import com.matricula.controlmatricula.model.Estudiante;
import com.matricula.controlmatricula.service.IEstudianteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/estudiante")
@RequiredArgsConstructor
public class EstudianteController {

    private final IEstudianteService service;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<GenericResponse<EstudianteDTO>> readAll() throws Exception{

        List<EstudianteDTO> list = service.readAll().stream().map(this::converToDTO).toList() ;
        return new ResponseEntity<>(new GenericResponse<>(200, "success", list), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponse<EstudianteDTO>> readById(@PathVariable("id") Integer id) throws Exception{
        Estudiante obj = service.readById(id);
        return ResponseEntity.ok(new GenericResponse<>(200, "success", Arrays.asList(converToDTO(obj))));
    }

    @PostMapping
    public ResponseEntity<GenericResponse<EstudianteDTO>> save(@Valid @RequestBody EstudianteDTO dto) throws Exception{
        Estudiante obj = service.save(converToEntity(dto));
        return new ResponseEntity<>(new GenericResponse<>(200, "success", Arrays.asList(converToDTO(obj))), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<GenericResponse<EstudianteDTO>> update(@Valid @RequestBody EstudianteDTO dto, @PathVariable("id") Integer id) throws Exception{
        dto.setIdEstudiante(id);
        Estudiante obj = service.update(converToEntity(dto), id);
        return new ResponseEntity<>(new GenericResponse<>(200, "success", Arrays.asList(converToDTO(obj))), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    private Estudiante converToEntity(EstudianteDTO dto){
        return modelMapper.map(dto, Estudiante.class);
    }

    private EstudianteDTO converToDTO(Estudiante estudiante){
        return modelMapper.map(estudiante, EstudianteDTO.class);
    }

    @GetMapping("/get/nombres/apellidos")
    public ResponseEntity<GenericResponse<EstudianteDTO>> getNombresApellidos(@RequestParam("nombres") String nombres, @RequestParam("apellidos") String apellidos) throws Exception{

        List<EstudianteDTO> list = service.getNombresApellidos(nombres, apellidos).stream().map(this::converToDTO).toList() ;
        return new ResponseEntity<>(new GenericResponse<>(200, "success", list), HttpStatus.OK);

    }

    @GetMapping("/estudiantemaxedad")
    public ResponseEntity<EstudianteDTO> getEstudianteMaxEdad() throws Exception{

        EstudianteDTO  dto = converToDTO(service.getEstudianteMaxEdad());
        return new ResponseEntity<>(dto, HttpStatus.OK);

    }

    @GetMapping("/estudianteporedad")
    public ResponseEntity<List<EstudianteDTO>> getEstudiantesPorEdad() throws Exception{

        List<EstudianteDTO>  list = service.getEstudiantesPorEdad().stream().map(this::converToDTO).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);

    }
}
