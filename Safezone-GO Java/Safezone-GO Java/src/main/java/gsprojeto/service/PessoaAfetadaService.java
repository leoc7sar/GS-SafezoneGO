package gsprojeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gsprojeto.dto.PessoaAfetadaDTO;
import gsprojeto.model.Abrigo;
import gsprojeto.model.Evento;
import gsprojeto.model.PessoaAfetada;
import gsprojeto.repositories.AbrigoRepository;
import gsprojeto.repositories.EventoRepository;
import gsprojeto.repositories.PessoaAfetadaRepository;

@Service
public class PessoaAfetadaService {

	@Autowired
	private PessoaAfetadaRepository repository;

	public PessoaAfetadaDTO salvar(PessoaAfetadaDTO dto) {
		PessoaAfetada pessoa = new PessoaAfetada();
		pessoa.setNome(dto.getNome());
		pessoa.setIdade(dto.getIdade());
		pessoa.setContato(dto.getContato());

		repository.save(pessoa);
		return toPessoaDTO(pessoa);
	}

	public Page<PessoaAfetadaDTO> listar(Pageable pageable) {
		return repository.findAll(pageable).map(this::toPessoaDTO);
	}

	public PessoaAfetadaDTO atualizar(Long id, PessoaAfetadaDTO dto) {
		PessoaAfetada pessoa = repository.findById(id).orElseThrow();

		pessoa.setNome(dto.getNome());
		pessoa.setIdade(dto.getIdade());
		pessoa.setContato(dto.getContato());

		repository.save(pessoa);
		return toPessoaDTO(pessoa);
	}

	public void deletar(Long id) {
		repository.deleteById(id);
	}

	private PessoaAfetadaDTO toPessoaDTO(PessoaAfetada pessoa) {
		PessoaAfetadaDTO dto = new PessoaAfetadaDTO();
		dto.setId(pessoa.getId());
		dto.setNome(pessoa.getNome());
		dto.setIdade(pessoa.getIdade());
		dto.setContato(pessoa.getContato());

		return dto;
	}
}
