package com.example.sistema_agendamento.dto.clienteDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private Long agendamentoId;
}
