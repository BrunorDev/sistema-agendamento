package com.example.sistema_agendamento.controller;

import com.example.sistema_agendamento.dto.agendamentoDTO.AgendamentoRequest;
import com.example.sistema_agendamento.dto.agendamentoDTO.AgendamentoResponse;
import com.example.sistema_agendamento.entities.Agendamento;
import com.example.sistema_agendamento.mappers.AgendamentoMapper;
import com.example.sistema_agendamento.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService agendamentoService;

    @Autowired
    private AgendamentoMapper agendamentoMapper;

    @PostMapping
    public ResponseEntity<AgendamentoResponse> criarAgendamento(@RequestBody AgendamentoRequest request){
         AgendamentoResponse agendamento = agendamentoService.criarAgendamento(request);
         return ResponseEntity.status(HttpStatus.CREATED).body(agendamento);
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoResponse>> listarAgendamentos(){
         List<AgendamentoResponse> agendamentos = agendamentoService.listarAgendamentos();

        if (agendamentos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(agendamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendamentoResponse> buscarAgendamentoPorId(@PathVariable Long id){
         AgendamentoResponse agendamento = agendamentoService.buscarAgendamentoPorId(id);
         return ResponseEntity.ok(agendamento);
    }

    @GetMapping(params = "data")
    public ResponseEntity<List<AgendamentoResponse>> listarPorData(
            @RequestParam("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {

        List<Agendamento> agendamentos = agendamentoService.listarPorData(data);
        List<AgendamentoResponse> agendamentoResponses = agendamentoMapper.toAgendamentoResponseList(agendamentos);

        return ResponseEntity.ok(agendamentoResponses);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAgendamento(@PathVariable Long id){
        agendamentoService.deletarAgendamento(id);
        return ResponseEntity.noContent().build();
    }
}
