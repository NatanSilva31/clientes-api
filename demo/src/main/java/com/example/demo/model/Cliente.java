//@Entity: diz ao Spring que essa classe é uma tabela.
//@Id e @GeneratedValue: chave primária auto-gerada.
//Lombok elimina getters/setters.

package com.example.demo.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private String email;
    private String cpf;

}
