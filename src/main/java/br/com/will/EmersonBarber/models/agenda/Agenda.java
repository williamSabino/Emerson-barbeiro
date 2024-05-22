package br.com.will.EmersonBarber.models.agenda;

import br.com.will.EmersonBarber.dto.AgendaDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "agenda")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Agenda {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String numero;
    private LocalDate data;
    private LocalTime hora;
    private boolean degrade;
    private boolean tesoura;
    private boolean barba;
    private boolean test1;
    private boolean test2;
    private boolean outros;

    public Agenda(AgendaDto agendaDto) {
        this.nome = agendaDto.nome();
        this.numero = agendaDto.numero();
        this.data = agendaDto.data();
        this.hora = agendaDto.hora();
        this.tesoura = Objects.equals(agendaDto.tesoura(), "on");
        this.degrade =  Objects.equals(agendaDto.degrade(), "on");
        this.outros =  Objects.equals(agendaDto.outros(), "on");
        this.test1 =  Objects.equals(agendaDto.test1(), "on");
        this.test2 =  Objects.equals(agendaDto.test2(), "on");
        this.barba =  Objects.equals(agendaDto.barba(), "on");
    }
}
