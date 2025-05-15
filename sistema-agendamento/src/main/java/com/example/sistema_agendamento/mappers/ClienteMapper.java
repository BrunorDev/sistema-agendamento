package com.example.sistema_agendamento.mappers;

import com.example.sistema_agendamento.dto.clienteDTO.ClienteRequest;
import com.example.sistema_agendamento.dto.clienteDTO.ClienteResponse;
import com.example.sistema_agendamento.entities.Cliente;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Cliente toCliente(ClienteRequest request){
        return modelMapper.map(request, Cliente.class);
    }

    public ClienteResponse toClienteResponse(Cliente cliente){
        return modelMapper.map(cliente, ClienteResponse.class);
    }

    public List<ClienteResponse> toClienteResponseList(List<Cliente> clientes){
        return clientes.stream().map(this::toClienteResponse).collect(Collectors.toList());
    }
}
