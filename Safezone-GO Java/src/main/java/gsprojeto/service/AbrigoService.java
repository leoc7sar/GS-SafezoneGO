package gsprojeto.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import gsprojeto.dto.AbrigoDTO;
import gsprojeto.model.Abrigo;
import gsprojeto.repositories.AbrigoRepository;

@Service
public class AbrigoService {

    @Autowired
    private AbrigoRepository repository;

    public AbrigoDTO salvar(AbrigoDTO dto) {
        Abrigo abrigo = new Abrigo();
        abrigo.setCapacidade(dto.getCapacidade());
        abrigo.setRecursos(dto.getRecursos());
        abrigo.setLocalizacao(dto.getLocalizacao());

        repository.save(abrigo);
        return toAbrigoDTO(abrigo);
    }

    public Page<AbrigoDTO> listar(PageRequest page) {
        return repository.findAll(page).map(this::toAbrigoDTO);
    }

    public AbrigoDTO atualizar(Long id, AbrigoDTO dto) {
        Abrigo abrigo = repository.findById(id).orElseThrow();

        abrigo.setCapacidade(dto.getCapacidade());
        abrigo.setRecursos(dto.getRecursos());
        abrigo.setLocalizacao(dto.getLocalizacao());

        repository.save(abrigo);
        return toAbrigoDTO(abrigo);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    private AbrigoDTO toAbrigoDTO(Abrigo abrigo) {
        AbrigoDTO dto = new AbrigoDTO();
        dto.setId(abrigo.getId());
        dto.setCapacidade(abrigo.getCapacidade());
        dto.setRecursos(abrigo.getRecursos());
        dto.setLocalizacao(abrigo.getLocalizacao());
        dto.setTotalPessoasAfetadas(abrigo.getPessoasAfetadas() != null ? abrigo.getPessoasAfetadas().size() : 0);
        return dto;
    }

	private <U> U toResponseDTO(AbrigoDTO abrigoresponsedto1) {
		return null;
	}
}
