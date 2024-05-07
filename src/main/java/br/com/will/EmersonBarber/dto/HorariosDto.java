package br.com.will.EmersonBarber.dto;

import br.com.will.EmersonBarber.models.horario.Horario;

import java.time.LocalDate;
import java.time.LocalTime;

public record HorariosDto(
        String data,
        LocalTime Hora,
        boolean agendado,
        String nome
) {
}
