package com.example.sistema_agendamento.repositories;

import com.example.sistema_agendamento.entities.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
    List<Agendamento> findByDataHoraBetween(LocalDateTime inicio, LocalDateTime fim);
    Boolean existsByDataHora(LocalDateTime request);
}
