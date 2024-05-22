package br.com.will.EmersonBarber.service;

import br.com.will.EmersonBarber.dto.AgendaDto;
import br.com.will.EmersonBarber.dto.HorariosDtoJson;
import br.com.will.EmersonBarber.models.agenda.Agenda;
import br.com.will.EmersonBarber.models.horario.Horario;
import br.com.will.EmersonBarber.repository.AgendaRepository;
import br.com.will.EmersonBarber.repository.HorariosRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class AgendaService {
    @Autowired
    private HorariosRepository horariosRepository;
    @Autowired
    private AgendaRepository agendaRepository;
    JsonMapper mapper = new JsonMapper();

    public String agendarHome(ModelMap model) throws JsonProcessingException {
        var dataHoje = LocalDate.now();

        var horarios = horariosRepository.listarHorariosDisponiveis(dataHoje);
        var datas = horarios.stream().map(Horario::getData).distinct().toList();

        var listaDto = horarios.stream()
                .map(HorariosDtoJson::new).toList();

        var horariosJson = mapper.writeValueAsString(listaDto);

        //testes
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println(horariosJson);

        model.addAttribute("datas", datas);
        model.addAttribute("horarios", horariosJson);

        return "agendar";
    }

    public String agendar(AgendaDto agendaDto) {
        Agenda agendamento = new Agenda(agendaDto);
        agendaRepository.save(agendamento);
        Optional<Horario> horario = horariosRepository.findByDataAndHora(agendamento.getData(), agendamento.getHora());
        horario.ifPresent(value -> value.setAgendado(true));
        return "index";
    }
}
