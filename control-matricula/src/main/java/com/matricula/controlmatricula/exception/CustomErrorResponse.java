package com.matricula.controlmatricula.exception;

import java.time.LocalDateTime;

public record CustomErrorResponse (
        LocalDateTime dateTime,
        String message,
        String path

){

}
