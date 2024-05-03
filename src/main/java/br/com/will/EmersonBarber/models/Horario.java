package br.com.will.EmersonBarber.models;

import br.com.will.EmersonBarber.dto.HorariosDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "horarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Horario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private LocalTime hora;
    private boolean agendado;
    private String nome;

    public Horario(HorariosDto h) {
        this.data = LocalDate.parse(h.data(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.hora = h.Hora();
        this.agendado = false;
        this.nome = h.nome() != null ? h.nome() : "";
    }
}
