package com.example.sistema_agendamento.mappers;

import com.example.sistema_agendamento.dto.agendamentoDTO.AgendamentoRequest;
import com.example.sistema_agendamento.dto.agendamentoDTO.AgendamentoResponse;
import com.example.sistema_agendamento.entities.Agendamento;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AgendamentoMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Agendamento toAgendamento(AgendamentoRequest request){
        return modelMapper.map(request, Agendamento.class);
    }

    public AgendamentoResponse toAgendamentoResponse(Agendamento agendamento){
        return modelMapper.map(agendamento, AgendamentoResponse.class);
    }

    public List<AgendamentoResponse> toAgendamentoResponseList(List<Agendamento> agendamentos){
        return agendamentos.stream().map(this::toAgendamentoResponse).collect(Collectors.toList());
    }
}
