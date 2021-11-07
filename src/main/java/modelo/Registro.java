package modelo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "Registro")
public class Registro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	private long id;
	@Expose
	private Long idPessoa;
	
	@Expose
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "id_laboratorio", referencedColumnName = "id")
	private Laboratorio laboratorio;
	@Expose
	private String acao;
	@Expose
	private String hora;

	public Registro() {

	}

	public Registro(Long idPessoa, Laboratorio laboratorio, String acao, String hora) {
		super();
		this.id = id;
		this.idPessoa = idPessoa;
		this.laboratorio = laboratorio;
		this.acao = acao;
		this.hora = hora;
	}

	public Laboratorio getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Long getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

}
