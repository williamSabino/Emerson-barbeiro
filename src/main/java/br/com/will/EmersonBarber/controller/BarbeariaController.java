package br.com.will.EmersonBarber.controller;

import br.com.will.EmersonBarber.dto.AgendaDto;
import br.com.will.EmersonBarber.dto.GerarDatasDto;
import br.com.will.EmersonBarber.service.BarbeariaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/login")
    public String login(){ return "login"; }

    @PostMapping("/login")
    public  String loginEntrar(ModelMap modelMap) throws JsonProcessingException {
        return service.quadroHorarios(modelMap);
    }

    @PostMapping(path = "/gerar-datas", consumes = "application/x-www-form-urlencoded")
    public String gerarDatas(GerarDatasDto gerarDatasDto){
        return service.gerarData(gerarDatasDto);
    };

    @GetMapping("/deletar/{id}")
    @Transactional
    public String deletar(@PathVariable Long id, ModelMap modelMap) throws JsonProcessingException {
        return service.deletar(id, modelMap);
    }

}
