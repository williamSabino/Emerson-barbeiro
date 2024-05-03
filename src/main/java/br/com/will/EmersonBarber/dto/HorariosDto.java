package br.com.will.EmersonBarber.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public record HorariosDto(
        String data,
        LocalTime Hora,
        boolean agendado,
        String nome
) {
}
