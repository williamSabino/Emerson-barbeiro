package br.com.will.EmersonBarber.dto;

import br.com.will.EmersonBarber.models.agenda.Agenda;

import java.time.LocalDate;
import java.time.LocalTime;

public record AgendaDto(
        String nome,
        String numero,
        String degrade,
        String tesoura,
        String barba,
        String test1,
        String test2,
        String outros,
        LocalDate data,
        LocalTime hora
) {
}
