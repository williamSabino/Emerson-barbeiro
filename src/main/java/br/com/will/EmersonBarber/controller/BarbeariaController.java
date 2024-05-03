package br.com.will.EmersonBarber.controller;

import br.com.will.EmersonBarber.dto.GerarDatasDto;
import br.com.will.EmersonBarber.service.BarbeariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emerson-barbeiro")
public class BarbeariaController {
    @Autowired
    private BarbeariaService service;


    @GetMapping
    public String home(){
        return "index";
    }

    @PostMapping(path = "/gerar-datas", consumes = "application/x-www-form-urlencoded")
    public String gerarDatas(GerarDatasDto gerarDatasDto){
        return service.gerarData(gerarDatasDto);
    };

}
