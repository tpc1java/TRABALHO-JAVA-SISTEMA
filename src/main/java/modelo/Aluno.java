package modelo;
import javax.persistence.Entity;

@Entity
public class Aluno extends Pessoa {
	private Turno turno;
	
	public Aluno() {
		
	}
	
	
	public Aluno(String nome, String email, String cpf, Turno turno) {
		super(email, nome , cpf);
		this.turno = turno;
		
	}


	public Turno getTurno() {
		return turno;
	}


	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	
}
