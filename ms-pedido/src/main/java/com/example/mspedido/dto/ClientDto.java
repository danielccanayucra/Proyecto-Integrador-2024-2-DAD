package com.example.mspedido.dto;

import lombok.Data;

@Data
public class ClientDto {
    private Integer id;
    private String name;
    private String apellido;
    private String telefono;
    private String document;
}