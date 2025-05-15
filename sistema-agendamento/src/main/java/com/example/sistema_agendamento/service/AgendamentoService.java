package com.example.sistema_agendamento.service;

import com.example.sistema_agendamento.dto.agendamentoDTO.AgendamentoRequest;
import com.example.sistema_agendamento.dto.agendamentoDTO.AgendamentoResponse;
import com.example.sistema_agendamento.entities.Agendamento;
import com.example.sistema_agendamento.entities.Cliente;
import com.example.sistema_agendamento.entities.Servico;
import com.example.sistema_agendamento.mappers.AgendamentoMapper;
import com.example.sistema_agendamento.repositories.AgendamentoRepository;
import com.example.sistema_agendamento.repositories.ClienteRepository;
import com.example.sistema_agendamento.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Autowired
    private AgendamentoMapper agendamentoMapper;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ServicoRepository servicoRepository;


    public AgendamentoResponse criarAgendamento(AgendamentoRequest request){
        boolean existe = agendamentoRepository.existsByDataHora(request.getDataHora());

        if(existe){
            throw new RuntimeException("Consulta já marcada nesse horario");
        }

        Cliente cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Servico servico = servicoRepository.findById(request.getServicoId())
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        Agendamento agendamento = new Agendamento();
        agendamento.setDataHora(request.getDataHora());
        agendamento.setCliente(cliente);
        agendamento.setServico(servico);

        Agendamento agendamentoSalvo = agendamentoRepository.save(agendamento);

        return agendamentoMapper.toAgendamentoResponse(agendamentoSalvo);

    }

    public List<AgendamentoResponse> listarAgendamentos() {
        List<Agendamento> agendamentos = agendamentoRepository.findAll();
        return agendamentoMapper.toAgendamentoResponseList(agendamentos);
    }

    public AgendamentoResponse buscarAgendamentoPorId(Long id) {
        Agendamento agendamento = agendamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Agendamento não encontrado"));

        return agendamentoMapper.toAgendamentoResponse(agendamento);
    }

    public List<Agendamento> listarPorData(LocalDate data) {
        LocalDateTime inicioDoDia = data.atStartOfDay();
        LocalDateTime fimDoDia = data.atTime(LocalTime.MAX);

        return agendamentoRepository.findByDataHoraBetween(inicioDoDia, fimDoDia);
    }

    public void deletarAgendamento(Long id) {
        if (!agendamentoRepository.existsById(id)) {
            throw new RuntimeException("Agendamento não encontrado");
        }
        agendamentoRepository.deleteById(id);
    }
}
