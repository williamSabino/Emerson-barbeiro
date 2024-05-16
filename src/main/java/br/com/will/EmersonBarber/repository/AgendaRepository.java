package br.com.will.EmersonBarber.repository;

import br.com.will.EmersonBarber.dto.AgendaDto;
import br.com.will.EmersonBarber.models.agenda.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
}
