package modelo;

import javax.persistence.Entity;

@Entity
public class Professor extends Pessoa {
	public Professor() {
		
	}

	public Professor(String nome, String email, String cpf) {
		super(email, nome , cpf);
		
	}


}
