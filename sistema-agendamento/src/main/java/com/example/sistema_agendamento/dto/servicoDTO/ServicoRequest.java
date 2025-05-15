package com.example.sistema_agendamento.dto.servicoDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServicoRequest {

    private String nome;

    private String descricao;

    private BigDecimal preco;


}
