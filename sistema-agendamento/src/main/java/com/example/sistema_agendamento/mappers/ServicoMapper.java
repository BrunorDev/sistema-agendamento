package com.example.sistema_agendamento.mappers;

import com.example.sistema_agendamento.dto.servicoDTO.ServicoRequest;
import com.example.sistema_agendamento.dto.servicoDTO.ServicoResponse;
import com.example.sistema_agendamento.entities.Servico;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ServicoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Servico toServico(ServicoRequest request){
        return modelMapper.map(request, Servico.class);
    }

    public ServicoResponse toServicoResponse(Servico servico){
        return modelMapper.map(servico, ServicoResponse.class);
    }

    public List<ServicoResponse> toServicoResponseList(List<Servico> servicos){
        return servicos.stream().map(this::toServicoResponse).collect(Collectors.toList());
    }
}
