package gsprojeto.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "evento")
public class Evento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String tipo;

	@NotNull
	private Integer intensidade;

	@NotBlank
	private String localizacao;

	@OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
	private List<PessoaAfetada> pessoasAfetadas;

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

	public List<PessoaAfetada> getPessoasAfetadas() {
		return pessoasAfetadas;
	}

	public void setPessoasAfetadas(List<PessoaAfetada> pessoasAfetadas) {
		this.pessoasAfetadas = pessoasAfetadas;
	}

	
}
