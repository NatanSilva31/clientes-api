package com.example.demo.dto;

import lombok.Data;

@Data
public class ClienteResponse {
    private Long id;
    private String nome;
    private String email;
    private String cpf;
}
