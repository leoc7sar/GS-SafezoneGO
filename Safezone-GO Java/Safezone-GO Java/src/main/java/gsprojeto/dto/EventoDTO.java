package gsprojeto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EventoDTO {

	private Long id;

	@NotBlank(message = "a descrição não pode estar em branco")
	private String descricao;

	@NotNull(message = "A intensidade é obrigatória")
	private Integer intensidade;

	@NotBlank(message = "A localização não pode estar em branco")
	private String local_evento;

	private Integer totalPessoasAfetadas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getIntensidade() {
		return intensidade;
	}

	public void setIntensidade(Integer intensidade) {
		this.intensidade = intensidade;
	}

	public Integer getTotalPessoasAfetadas() {
		return totalPessoasAfetadas;
	}

	public void setTotalPessoasAfetadas(Integer totalPessoasAfetadas) {
		this.totalPessoasAfetadas = totalPessoasAfetadas;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLocal_evento() {
		return local_evento;
	}

	public void setLocal_evento(String local_evento) {
		this.local_evento = local_evento;
	}

}
