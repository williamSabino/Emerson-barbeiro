package br.com.will.EmersonBarber.dto;

import br.com.will.EmersonBarber.models.horario.Horario;

import java.time.LocalTime;

public record HorariosDtoJson (
        String data,
        String hora,
        boolean agendado,
        String nome
){
    public HorariosDtoJson(Horario h) {
        this(String.valueOf(h.getData()), String.valueOf(h.getHora()),h.isAgendado(), h.getNome());
    }
}
