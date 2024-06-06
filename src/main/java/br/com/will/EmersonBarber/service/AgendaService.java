package br.com.will.EmersonBarber.service;

import br.com.will.EmersonBarber.dto.AgendaDto;
import br.com.will.EmersonBarber.dto.HorariosDtoJson;
import br.com.will.EmersonBarber.models.agenda.Agenda;
import br.com.will.EmersonBarber.models.horario.Horario;
import br.com.will.EmersonBarber.repository.AgendaRepository;
import br.com.will.EmersonBarber.repository.HorariosRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.io.IOException;
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
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public String agendarHome(ModelMap model) throws JsonProcessingException {
        var dataHoje = LocalDate.now();

        var horarios = horariosRepository.listarHorariosDisponiveis(dataHoje);
        var datas = horarios.stream().map(Horario::getData).distinct().toList();

        var listaDto = horarios.stream()
                .map(HorariosDtoJson::new).toList();

        var horariosJson = mapper.writeValueAsString(listaDto);

        model.addAttribute("datas", datas);
        model.addAttribute("horarios", horariosJson);

        return "agendar";
    }

    public void agendar(AgendaDto agendaDto, HttpServletResponse response) throws IOException {
        Agenda agendamento = new Agenda(agendaDto);
        agendaRepository.save(agendamento);
        Optional<Horario> horario = horariosRepository.findByDataAndHora(agendamento.getData(), agendamento.getHora());
        horario.ifPresent(value -> value.setAgendado(true));
        redirecionarWhatsapp(agendaDto, response);
    }

    private void redirecionarWhatsapp(AgendaDto agendaDto, HttpServletResponse response) throws IOException {
        String data = agendaDto.data().getDayOfMonth() + "-" + agendaDto.data().getMonthValue() +"-"+ agendaDto.data().getYear();
        var link = "https://wa.me/8182249891?text=Ola%20agendamento%20concluido%20nome:"+agendaDto.nome()+"%20data:"+data+"%20hora:"+agendaDto.hora();
        response.sendRedirect(link);
    }
}
