package com.example.sistema_agendamento.controller;

import com.example.sistema_agendamento.dto.servicoDTO.ServicoRequest;
import com.example.sistema_agendamento.dto.servicoDTO.ServicoResponse;
import com.example.sistema_agendamento.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public ResponseEntity<ServicoResponse> criarServico(@RequestBody ServicoRequest request) {
        ServicoResponse servico = servicoService.criarServico(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(servico);
    }

    @GetMapping
    public ResponseEntity<List<ServicoResponse>> listarServicos() {
        List<ServicoResponse> servicos = servicoService.listarServicos();

        if (servicos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(servicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoResponse> buscarServicoPorId(@PathVariable Long id) {
        ServicoResponse servico = servicoService.buscarServicoPorId(id);
        return ResponseEntity.ok(servico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoResponse> atualizarServico(@PathVariable Long id, @RequestBody ServicoRequest request) {
        ServicoResponse servico = servicoService.atualizarServico(id, request);
        return ResponseEntity.ok(servico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarServico(@PathVariable Long id){
        servicoService.deletarServico(id);
        return ResponseEntity.noContent().build();
    }
}
