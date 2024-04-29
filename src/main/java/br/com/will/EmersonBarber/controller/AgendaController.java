package br.com.will.EmersonBarber.controller;

import br.com.will.EmersonBarber.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emerson-barbeiro/agenda")
public class AgendaController {
    @Autowired
    private AgendaService service;

    @GetMapping
    public String agendar(){
        return "agendar";
    }
}
