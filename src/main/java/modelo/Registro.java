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

@Entity
public class Registro {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private Long idPessoa;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_laboratorio", referencedColumnName = "id")
	private Laboratorio laboratorio;
	private Date  horaDeEntrada;
	private Date  horaDeSaida;
	
	public Registro() {
	
	}
	
	public Registro(Long idPessoa, Laboratorio laboratorio, Date horaDeEntrada) {
		super();
		this.id = id;
		this.idPessoa = idPessoa;
		this.laboratorio = laboratorio;
		this.horaDeEntrada = horaDeEntrada;
		this.horaDeSaida = null;
	}
	public Laboratorio getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(Laboratorio laboratorio) {
		this.laboratorio = laboratorio;
	}
	public Date getHoraDeEntrada() {
		return horaDeEntrada;
	}
	public void setHoraDeEntrada(Date horaDeEntrada) {
		this.horaDeEntrada = horaDeEntrada;
	}
	public Date getHoraDeSaida() {
		return horaDeSaida;
	}
	public void setHoraDeSaida(Date horaDeSaida) {
		this.horaDeSaida = horaDeSaida;
	}
	
	
	
}
