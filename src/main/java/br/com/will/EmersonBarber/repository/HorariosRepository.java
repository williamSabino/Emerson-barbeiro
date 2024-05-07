package br.com.will.EmersonBarber.repository;

import br.com.will.EmersonBarber.dto.HorariosDto;
import br.com.will.EmersonBarber.models.horario.Horario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface HorariosRepository extends JpaRepository<Horario, Long> {

    @Query("""
            SELECT h FROM Horario h 
            WHERE h.data >= :dataHoje
            """)
    List<Horario> listarHorariosDisponiveis(LocalDate dataHoje);

    Optional<Horario> findByDataAndHora(LocalDate dataDoCorte, LocalTime horario);
}
