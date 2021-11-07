package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.google.gson.annotations.Expose;

@Entity
public class Laboratorio {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	private long id;
	private String codigo;
	private int totalAssentos;

	@ManyToMany()
	private List<Aluno> alunos = new ArrayList<Aluno>();

	@ManyToMany()
	private List<Professor> professores = new ArrayList<Professor>();

	public Laboratorio() {

	}

	public Laboratorio(String codigo, int totalAssentos) {
		super();
		this.codigo = codigo;
		this.totalAssentos = totalAssentos;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getTotalAssentos() {
		return totalAssentos;
	}

	public void setTotalAssentos(int totalAssentos) {
		this.totalAssentos = totalAssentos;
	}

	public List<Aluno> getAlunos() {
		return this.alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Professor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

}
