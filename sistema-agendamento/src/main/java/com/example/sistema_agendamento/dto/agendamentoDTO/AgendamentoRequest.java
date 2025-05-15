package com.example.sistema_agendamento.dto.agendamentoDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgendamentoRequest {

    private Long clienteId;
    private Long servicoId;
    private LocalDateTime dataHora;
}
