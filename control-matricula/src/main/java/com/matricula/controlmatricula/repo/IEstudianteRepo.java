package com.matricula.controlmatricula.repo;


import com.matricula.controlmatricula.model.Estudiante;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IEstudianteRepo extends IGenericRepo<Estudiante, Integer> {

    //JPQL
    @Query("FROM Estudiante e WHERE e.nombres = :nombres AND e.apellidos LIKE %:apellidos%")
    List<Estudiante> getNombresApellidos(@Param("nombres") String nombres, @Param("apellidos") String apellidos);

    //NativeQuery
    @Query(value = "SELECT * FROM Estudiante e WHERE e.nombres = :nombres", nativeQuery = true)
    List<Estudiante> getNombresSQL(@Param("nombres") String nombres);

    @Modifying
    @Query(value = "UPDATE Estudiante SET nombres= :nombres", nativeQuery = true)
    Integer updateNames(@Param("nombre") String nombres);
}
