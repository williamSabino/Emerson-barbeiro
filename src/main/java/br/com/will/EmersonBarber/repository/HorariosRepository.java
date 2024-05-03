package br.com.will.EmersonBarber.repository;

import br.com.will.EmersonBarber.models.Horario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorariosRepository extends JpaRepository<Horario, Long> {
}
