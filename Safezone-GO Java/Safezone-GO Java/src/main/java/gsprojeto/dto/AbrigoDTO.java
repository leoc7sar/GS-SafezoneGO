package gsprojeto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class AbrigoDTO {

	private Long id;

	private String nome;

	@Positive(message = "A capacidade deve ser um número positivo")
	private Integer capacidade;

	@NotBlank(message = "Os recursos não podem estar em branco")
	private String recursos;

	@NotBlank(message = "A localização não pode estar em branco")
	private String localizacao;

	private Integer totalPessoasAfetadas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}

	public String getRecursos() {
		return recursos;
	}

	public void setRecursos(String recursos) {
		this.recursos = recursos;
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
