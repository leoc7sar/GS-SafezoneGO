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

import gsprojeto.dto.PessoaAfetadaDTO;
import gsprojeto.service.PessoaAfetadaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pessoas")
@CrossOrigin
public class PessoaAfetadaController {

    @Autowired
    private PessoaAfetadaService service;

    @PostMapping
    public PessoaAfetadaDTO criar(@Valid @RequestBody PessoaAfetadaDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping(value = "/lista")
    public Page<PessoaAfetadaDTO> listar(Pageable pageable) {
        return service.listar(pageable);
    }

    @PutMapping("/{id}")
    public PessoaAfetadaDTO atualizar(@PathVariable Long id, @Valid @RequestBody PessoaAfetadaDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
