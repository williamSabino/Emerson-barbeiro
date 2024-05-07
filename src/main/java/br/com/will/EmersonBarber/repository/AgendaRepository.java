package br.com.will.EmersonBarber.repository;

import br.com.will.EmersonBarber.models.agenda.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<Agenda, Long> {
}
