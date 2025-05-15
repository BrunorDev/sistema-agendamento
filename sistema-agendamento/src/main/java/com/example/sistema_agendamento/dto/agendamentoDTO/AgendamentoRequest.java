package com.example.sistema_agendamento.dto.agendamentoDTO;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    private Long clienteId;

    @NotNull
    private Long servicoId;

    @NotNull
    @FutureOrPresent
    private LocalDateTime dataHora;
}
