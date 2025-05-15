package com.example.sistema_agendamento.controller;

import com.example.sistema_agendamento.dto.clienteDTO.ClienteRequest;
import com.example.sistema_agendamento.dto.clienteDTO.ClienteResponse;
import com.example.sistema_agendamento.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<ClienteResponse> criarCliente(@RequestBody ClienteRequest request){
         ClienteResponse cliente = clienteService.criarCliente(request);
         return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponse>> listarClientes(){
         List<ClienteResponse> clientes = clienteService.listarClientes();

         if(clientes.isEmpty()){
             return ResponseEntity.noContent().build();
         }
         return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> buscarClientePorId(@PathVariable Long id){
         ClienteResponse cliente = clienteService.buscarClientePorId(id);
         return ResponseEntity.ok(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> atualizarCliente(@PathVariable Long id, @RequestBody ClienteRequest request){
         ClienteResponse cliente = clienteService.atualizarCliente(id, request);
         return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
