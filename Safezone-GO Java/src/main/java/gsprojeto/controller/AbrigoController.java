package gsprojeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gsprojeto.dto.AbrigoDTO;
import gsprojeto.service.AbrigoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/abrigos")
@CrossOrigin
public class AbrigoController {

	@Autowired
	private AbrigoService service;

	@PostMapping
	public AbrigoDTO criar(@Valid @RequestBody AbrigoDTO dto) {
		return service.salvar(dto);
	}

	@GetMapping(value = "/lista")
	public ResponseEntity<Page<AbrigoDTO>> retornaAbrigos(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "size", defaultValue = "2") Integer size) {

		PageRequest req = PageRequest.of(page, size);

		Page<AbrigoDTO> abrigos = service.listar(req);

		return ResponseEntity.ok(abrigos);

	}

	@PutMapping("/{id}")
	public AbrigoDTO atualizar(@PathVariable Long id, @Valid @RequestBody AbrigoDTO dto) {
		return service.atualizar(id, dto);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		service.deletar(id);
	}
}
