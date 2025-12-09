package com.example.demo.controller;

import com.example.demo.dto.ClienteRequest;
import com.example.demo.dto.ClienteResponse;
import com.example.demo.model.Cliente;
import com.example.demo.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor

public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public ClienteResponse criar (@RequestBody ClienteRequest request)
        return service.criar(request);

    @GetMapping
    public List<Cliente> listar(){
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ClienteResponse buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ClienteResponse atualizar(@PathVariable Long id,
                                     @RequestBody ClienteRequest request) {
        return service.atualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
