package gsprojeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gsprojeto.dto.EventoDTO;
import gsprojeto.service.EventoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/eventos")
@CrossOrigin
public class EventoController {

    @Autowired
    private EventoService service;

    @PostMapping
    public EventoDTO criar(@Valid @RequestBody EventoDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping(value = "/lista")
    public Page<EventoDTO> listar(Pageable pageable) {
        return service.listar(pageable);
    }

    @PutMapping("/{id}")
    public EventoDTO atualizar(@PathVariable Long id, @Valid @RequestBody EventoDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
