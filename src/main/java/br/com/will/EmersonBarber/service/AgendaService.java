package br.com.will.EmersonBarber.service;

import br.com.will.EmersonBarber.dto.HorariosDto;
import br.com.will.EmersonBarber.models.horario.Horario;
import br.com.will.EmersonBarber.repository.HorariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class AgendaService {
    @Autowired
    private HorariosRepository horariosRepository;
    public String agendarHome(ModelMap model) {
        var dataHoje = LocalDate.now();
        LocalTime horaAgora = LocalTime.now();
        var horarios = horariosRepository.listarHorariosDisponiveis(dataHoje);
        var datas = horarios.stream().map(Horario::getData).distinct();
        var horas = horarios.stream().map(Horario::getHora).distinct();


        model.addAttribute("datas", datas);
        model.addAttribute("horarios", horarios);
        return "agendar";
    }
}
