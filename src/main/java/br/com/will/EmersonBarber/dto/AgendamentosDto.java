package br.com.will.EmersonBarber.dto;

public record AgendamentosDto(
        Long id,
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
