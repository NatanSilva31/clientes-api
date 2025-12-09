package com.example.demo.service;

import com.example.demo.dto.ClienteRequest;
import com.example.demo.dto.ClienteResponse;
import com.example.demo.exception.ClienteNotFoundException;
import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteResponse criar(ClienteRequest request) {
        Cliente cliente = new Cliente();
        cliente.setNome(request.getNome());
        cliente.setEmail(request.getEmail());
        cliente.setCpf(request.getCpf());

        Cliente salvo = repository.save(cliente);

        return toResponse(salvo);
    }

    public List<Cliente> ListarTodos(){
        return repository.findAll();
    }

    public ClienteResponse buscarPorId(Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));
        return toResponse(cliente);
    }

    public ClienteResponse atualizar(Long id, ClienteRequest request) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException(id));

        cliente.setNome(request.getNome());
        cliente.setEmail(request.getEmail());
        cliente.setCpf(request.getCpf());

        Cliente atualizado = repository.save(cliente);
        return toResponse(atualizado);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ClienteNotFoundException(id);
        }
        repository.deleteById(id);
    }

    private ClienteResponse toResponse(Cliente cliente) {
        ClienteResponse resp = new ClienteResponse();
        resp.setId(cliente.getId());
        resp.setNome(cliente.getNome());
        resp.setEmail(cliente.getEmail());
        resp.setCpf(cliente.getCpf());
        return resp;
    }

}

