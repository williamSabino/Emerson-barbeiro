package br.com.will.EmersonBarber.service;

import br.com.will.EmersonBarber.dto.GerarDatasDto;
import br.com.will.EmersonBarber.models.horario.Horario;
import br.com.will.EmersonBarber.repository.HorariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarbeariaService {
    @Autowired
    private GerarDatas gerarDatas;
    @Autowired
    private HorariosRepository horariosRepository;

    public String gerarData(GerarDatasDto gerarDatasDto) {
        var horariosDto = gerarDatas.gerarDatas(gerarDatasDto.dataInicial(), gerarDatasDto.dataFinal());
        var horarios = horariosDto.stream()
                .map(Horario::new).toList();
        horariosRepository.saveAll(horarios);
        return "index";
    }
}
