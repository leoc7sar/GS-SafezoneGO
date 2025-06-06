package gsprojeto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class PessoaAfetadaDTO {

	private Long id;

	@NotBlank(message = "O nome não pode estar em branco")
	private String nome;

	@NotNull(message = "A idade é obrigatória")
	@Positive(message = "A idade deve ser positiva")
	private Integer idade;

	@NotBlank(message = "O contato não pode estar em branco")
	private String contato;

	private String eventoTipo;
	private String abrigoLocalizacao;

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

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getEventoTipo() {
		return eventoTipo;
	}

	public void setEventoTipo(String eventoTipo) {
		this.eventoTipo = eventoTipo;
	}

	public String getAbrigoLocalizacao() {
		return abrigoLocalizacao;
	}

	public void setAbrigoLocalizacao(String abrigoLocalizacao) {
		this.abrigoLocalizacao = abrigoLocalizacao;
	}
}
