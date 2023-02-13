package com.example.apollofy.service.dto;

import org.jetbrains.annotations.NotNull;

public record PlaylistDTO (
        Long id,
        @NotNull String name,
        String description,
        //boolean (tipo primitivo) --> valor por defecto es false. Entonces cuando creas el objeto el valor por defecto será false.
        //por esto es importante poner Boolean clase
        Boolean isPublic) {
}

//ToDo: implementar DTO con record en las demás clases