package br.com.will.EmersonBarber.dto;

import br.com.will.EmersonBarber.models.agenda.Agenda;

import java.time.LocalDate;
import java.time.LocalTime;

public record AgendamentosDto(
        String nome,
        String numero,
        boolean degrade,
        boolean tesoura,
        boolean barba,
        boolean test1,
        boolean test2,
        boolean outros,
        String data,
        String hora
) {
}
