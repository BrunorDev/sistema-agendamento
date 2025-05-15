package com.example.sistema_agendamento.dto.servicoDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotNull
    @Positive
    private BigDecimal preco;

}
