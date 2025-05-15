package com.example.sistema_agendamento.service;

import com.example.sistema_agendamento.dto.servicoDTO.ServicoRequest;
import com.example.sistema_agendamento.dto.servicoDTO.ServicoResponse;
import com.example.sistema_agendamento.entities.Servico;
import com.example.sistema_agendamento.mappers.ServicoMapper;
import com.example.sistema_agendamento.repositories.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private ServicoMapper servicoMapper;

    public ServicoResponse criarServico(ServicoRequest request){
        Servico servico = servicoMapper.toServico(request);
        Servico servicoCadastrado = servicoRepository.save(servico);
        return servicoMapper.toServicoResponse(servicoCadastrado);
    }

    public List<ServicoResponse> listarServicos(){
        List<Servico> servicos = servicoRepository.findAll();
        return servicoMapper.toServicoResponseList(servicos);
    }

    public ServicoResponse buscarServicoPorId(Long id) {
        Servico servico = servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        return servicoMapper.toServicoResponse(servico);
    }

    public ServicoResponse atualizarServico(Long id, ServicoRequest request){
        Servico servico = servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        servico.setNome(request.getNome());
        servico.setPreco(request.getPreco());
        servico.setDescricao(request.getDescricao());

        servicoRepository.save(servico);

        return servicoMapper.toServicoResponse(servico);
    }

    public void deletarServico(Long id) {
        if (!servicoRepository.existsById(id)) {
            throw new RuntimeException("Serviço não encontrado");
        }
        servicoRepository.deleteById(id);
    }
}
