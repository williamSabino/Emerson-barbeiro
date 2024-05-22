package br.com.will.EmersonBarber.service;

import br.com.will.EmersonBarber.dto.AgendaDto;
import br.com.will.EmersonBarber.dto.AgendamentosDto;
import br.com.will.EmersonBarber.dto.GerarDatasDto;
import br.com.will.EmersonBarber.models.horario.Horario;
import br.com.will.EmersonBarber.repository.AgendaRepository;
import br.com.will.EmersonBarber.repository.HorariosRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.Objects;

import static java.util.stream.Collectors.toList;

@Service
public class BarbeariaService {
    @Autowired
    private GerarDatas gerarDatas;
    @Autowired
    private HorariosRepository horariosRepository;
    @Autowired
    private AgendaRepository agendaRepository;
     JsonMapper mapper = new JsonMapper();

    public String gerarData(GerarDatasDto gerarDatasDto) {
        var horariosDto = gerarDatas.gerarDatas(gerarDatasDto.dataInicial(), gerarDatasDto.dataFinal());
        var horarios = horariosDto.stream()
                .map(Horario::new)
                .map(h -> {
                    if (!horariosRepository.existsHorarioByData(h.getData())) {
                        return h;
                    }else {
                        return null;
                    }
                })
                .filter(Objects::nonNull).toList();
        horariosRepository.saveAll(horarios);
        return "index";
    }

    public String quadroHorarios(ModelMap modelMap) throws JsonProcessingException {
        var horarios = agendaRepository.findAll();
        var listaDto = horarios.stream()
                        .map(h -> new AgendamentosDto(
                                h.getNome(),
                                h.getNumero(),
                                h.isDegrade(),
                                h.isTesoura(),
                                h.isBarba(),
                                h.isTest1(),
                                h.isTest2(),
                                h.isOutros(),
                                h.getData().toString(),
                                h.getHora().toString()
                        )).toList();
        var json = mapper.writeValueAsString(listaDto);
        modelMap.addAttribute("agendamentos", json);
        return "agendamentos";
    }
}
