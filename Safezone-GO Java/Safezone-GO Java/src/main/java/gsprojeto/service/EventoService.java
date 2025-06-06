package gsprojeto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gsprojeto.dto.EventoDTO;
import gsprojeto.model.Evento;
import gsprojeto.repositories.EventoRepository;

@Service
public class EventoService {

    @Autowired
    private EventoRepository repository;

    public EventoDTO salvar(EventoDTO dto) {
        Evento evento = new Evento();
        evento.setDescricao(dto.getDescricao());
        evento.setIntensidade(dto.getIntensidade());
        evento.setLocal_evento(dto.getLocal_evento());

        repository.save(evento);
        return toEventoDTO(evento);
    }

    public Page<EventoDTO> listar(Pageable pageable) {
        return repository.findAll(pageable).map(this::toEventoDTO);
    }

    public EventoDTO atualizar(Long id, EventoDTO dto) {
        Evento evento = repository.findById(id).orElseThrow();

        evento.setDescricao(dto.getDescricao());
        evento.setIntensidade(dto.getIntensidade());
        evento.setLocal_evento(dto.getLocal_evento());

        repository.save(evento);
        return toEventoDTO(evento);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    private EventoDTO toEventoDTO(Evento evento) {
        EventoDTO dto = new EventoDTO();
        dto.setId(evento.getId());
        dto.setDescricao(evento.getDescricao());
        dto.setIntensidade(evento.getIntensidade());
        dto.setLocal_evento(evento.getLocal_evento());
        dto.setTotalPessoasAfetadas(evento.getPessoasAfetadas() != null ? evento.getPessoasAfetadas().size() : 0);
        return dto;
    }
}
