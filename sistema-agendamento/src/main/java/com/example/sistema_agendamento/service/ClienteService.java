package com.example.sistema_agendamento.service;

import com.example.sistema_agendamento.dto.clienteDTO.ClienteRequest;
import com.example.sistema_agendamento.dto.clienteDTO.ClienteResponse;
import com.example.sistema_agendamento.entities.Cliente;
import com.example.sistema_agendamento.mappers.ClienteMapper;
import com.example.sistema_agendamento.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteMapper clienteMapper;

    public ClienteResponse cadastrar(ClienteRequest request) {
        Cliente cliente = clienteMapper.toCliente(request);
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return clienteMapper.toClienteResponse(clienteSalvo);
    }

    public List<ClienteResponse> listarTodos() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clienteMapper.toClienteResponseList(clientes);
    }

    public ClienteResponse listarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        return clienteMapper.toClienteResponse(cliente);
    }

    public ClienteResponse atualizar(long id, ClienteRequest request) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        cliente.setNome(request.getNome());
        cliente.setEmail(request.getEmail());
        cliente.setTelefone(request.getTelefone());

        clienteRepository.save(cliente);

        return clienteMapper.toClienteResponse(cliente);
    }

    public void deletar(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado");
        }
        clienteRepository.deleteById(id);
    }
}
