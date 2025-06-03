package gsprojeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import gsprojeto.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {}

