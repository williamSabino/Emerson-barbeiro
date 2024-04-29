package br.com.will.EmersonBarber.models;

import br.com.will.EmersonBarber.models.agenda.TipoDeCorte;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

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
    private LocalDate dataDoCorte;
    private LocalTime horario;
    @Enumerated(EnumType.STRING)
    private TipoDeCorte tipoDeCorte;
}
