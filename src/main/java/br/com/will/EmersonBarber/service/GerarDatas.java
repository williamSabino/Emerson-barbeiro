package br.com.will.EmersonBarber.service;

import br.com.will.EmersonBarber.dto.HorariosDto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class GerarDatas {
    //gera datas baseado na data inicial e final informada pelo adm
    public void gerarDatas(String dateInicial, String dateFinal){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        var dateHoje = LocalDate.parse(dateInicial, formatter);
        var dataUmMes = LocalDate.parse(dateFinal, formatter);

        List<HorariosDto> horarios = new ArrayList<>();
        var diferencaDias = dateHoje.until(dataUmMes, ChronoUnit.DAYS);
        System.out.println(diferencaDias);

        for(var i=0;i<=diferencaDias;i++){
            LocalTime horaInicioManha = LocalTime.of(7,30);
            LocalTime horaInicioTarde = LocalTime.of(13, 30);
            for(var j=0;j<=8;j++){
                HorariosDto horario = new HorariosDto(dateHoje.format(formatter), horaInicioManha = horaInicioManha.plusMinutes(30), false, "");
                horarios.add(horario);
            }
            for(var k=0;k<=10;k++){
                HorariosDto horario = new HorariosDto(dateHoje.format(formatter), horaInicioTarde = horaInicioTarde.plusMinutes(30), false, "");
                horarios.add(horario);
            }
            dateHoje = dateHoje.plusDays(1);
        }
        horarios.forEach(System.out::println);
    }
}
