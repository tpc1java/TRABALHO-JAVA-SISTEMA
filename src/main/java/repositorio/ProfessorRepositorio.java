package repositorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import modelo.Professor;
import modelo.Turno;

import java.util.ArrayList;


public class ProfessorRepositorio {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-jpa");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	public ProfessorRepositorio() {

	}

	public Professor obterPorId(Long id) {
		Professor professor = entityManager.find(Professor.class, id);
		return professor != null ? professor : null;
	}

	public ArrayList<Professor> obterTodos() {
	        return (ArrayList<Professor>) entityManager.createQuery("from Professor").getResultList();
	 }

	public Professor adicionar (String nome, String email, String cpf) {
		Professor novoProfessor = new Professor(nome,  email,  cpf);
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(novoProfessor);
		this.entityManager.getTransaction().commit();
		System.out.println("Professor adicionado com sucesso");
		return novoProfessor;
	}
	
	public Professor atualizar (Long id,String nome, String email, String cpf) {
		Professor professor = this.entityManager.find(Professor.class, id);
		this.entityManager.getTransaction().begin();
		professor.setNome(nome);
		professor.setEmail(email);
		professor.setCpf(cpf);

		this.entityManager.getTransaction().commit();
		System.out.println("Professor atualizado com sucesso");
		return professor;
	}
	
	public void remover (Long id) {
		Professor professor = this.entityManager.find(Professor.class, id);
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(professor);
		this.entityManager.getTransaction().commit();
		System.out.println("professor removido com sucesso");
	}
	
		
}