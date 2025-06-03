package gsprojeto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EventoDTO {

	private Long id;

	@NotBlank(message = "O tipo não pode estar em branco")
	private String tipo;

	@NotNull(message = "A intensidade é obrigatória")
	private Integer intensidade;

	@NotBlank(message = "A localização não pode estar em branco")
	private String localizacao;

	private Integer totalPessoasAfetadas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getIntensidade() {
		return intensidade;
	}

	public void setIntensidade(Integer intensidade) {
		this.intensidade = intensidade;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public Integer getTotalPessoasAfetadas() {
		return totalPessoasAfetadas;
	}

	public void setTotalPessoasAfetadas(Integer totalPessoasAfetadas) {
		this.totalPessoasAfetadas = totalPessoasAfetadas;
	}
}
