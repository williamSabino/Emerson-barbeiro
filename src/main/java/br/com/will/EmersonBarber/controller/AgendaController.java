package br.com.will.EmersonBarber.controller;

import br.com.will.EmersonBarber.dto.AgendaDto;
import br.com.will.EmersonBarber.service.AgendaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/emerson-barbeiro/agenda")
public class AgendaController {
    @Autowired
    private AgendaService agendaService;

    @GetMapping
    public String agendarHome(ModelMap model) throws JsonProcessingException {
        return agendaService.agendarHome(model);
    }

    @Transactional
    @PostMapping(consumes = "application/x-www-form-urlencoded")
    public void agendar(AgendaDto agendaDto, HttpServletResponse response) throws IOException {
        agendaService.agendar(agendaDto, response);
    }
}
