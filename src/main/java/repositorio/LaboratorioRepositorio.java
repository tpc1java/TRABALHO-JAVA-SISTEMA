package repositorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import modelo.Aluno;
import modelo.Laboratorio;
import modelo.Professor;
import modelo.Turno;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LaboratorioRepositorio {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-jpa");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	public LaboratorioRepositorio() {

	}

	public Laboratorio obterPorId(Long id) {
		Laboratorio laboratorio = entityManager.find(Laboratorio.class, id);
		return laboratorio != null ? laboratorio : null;
	}

	public ArrayList<Laboratorio> obterTodos() {
		return (ArrayList<Laboratorio>) entityManager.createQuery("from Laboratorio").getResultList();
	}

	public Laboratorio adicionar(String codigo, int totalAssentos) {
		Laboratorio novoLaboratorio = new Laboratorio(codigo, totalAssentos);
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(novoLaboratorio);
		this.entityManager.getTransaction().commit();
		System.out.println("Laboratorio adicionado com sucesso");
		return novoLaboratorio;
	}

	public Laboratorio atualizar(Long id, String codigo, int totalAssentos) {
		Laboratorio laboratorio = this.entityManager.find(Laboratorio.class, id);
		this.entityManager.getTransaction().begin();
		laboratorio.setCodigo(codigo);
		laboratorio.setTotalAssentos(totalAssentos);
		this.entityManager.getTransaction().commit();
		System.out.println("Laboratorio atualizado com sucesso");
		return laboratorio;
	}

	public void autenticarAluno(Long idLaboratorio, Aluno aluno) {
		Laboratorio laboratorio = this.entityManager.find(Laboratorio.class, idLaboratorio);

		this.entityManager.getTransaction().begin();
		List<Aluno> alunos = laboratorio.getAlunos();
		alunos.add(aluno);
		laboratorio.setAlunos(alunos);
		this.entityManager.getTransaction().commit();
		System.out.println("Aluno autenticado com sucesso no lab: " + idLaboratorio);

		this.entityManager.getTransaction().begin();
		RegistroRepositorio registroRepositorio = new RegistroRepositorio();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		registroRepositorio.adicionar(aluno.getId(), laboratorio, "entrar", dtf.format(now));
		this.entityManager.getTransaction().commit();
	}

	public void desautenticarAluno(Long idLaboratorio, Aluno aluno) {
		Laboratorio laboratorio = this.entityManager.find(Laboratorio.class, idLaboratorio);

		this.entityManager.getTransaction().begin();
		List<Aluno> alunos = laboratorio.getAlunos();
		alunos.remove(alunos.indexOf(aluno));
		laboratorio.setAlunos(alunos);
		this.entityManager.getTransaction().commit();
		System.out.println("Aluno desautenticado  com sucesso no lab: " + idLaboratorio);
		
		this.entityManager.getTransaction().begin();
		RegistroRepositorio registroRepositorio = new RegistroRepositorio();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		registroRepositorio.adicionar(aluno.getId(), laboratorio, "sair", dtf.format(now));
		this.entityManager.getTransaction().commit();
	}

	public void autenticarProfessor(Long idLaboratorio, Professor professor) {
		Laboratorio laboratorio = this.entityManager.find(Laboratorio.class, idLaboratorio);

		this.entityManager.getTransaction().begin();
		List<Professor> professores = laboratorio.getProfessores();
		professores.add(professor);
		laboratorio.setProfessores(professores);
		this.entityManager.getTransaction().commit();
		System.out.println("Professor autenticado com sucesso no lab: " + idLaboratorio);
		
		this.entityManager.getTransaction().begin();
		RegistroRepositorio registroRepositorio = new RegistroRepositorio();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		registroRepositorio.adicionar(professor.getId(), laboratorio, "entrar", dtf.format(now));
		this.entityManager.getTransaction().commit();
	}

	public void desautenticarProfessor(Long idLaboratorio, Professor professor) {
		Laboratorio laboratorio = this.entityManager.find(Laboratorio.class, idLaboratorio);

		this.entityManager.getTransaction().begin();
		List<Aluno> professores = laboratorio.getAlunos();
		professores.remove(professores.indexOf(professor));
		laboratorio.setAlunos(professores);
		this.entityManager.getTransaction().commit();
		System.out.println("Professor desautenticado  com sucesso no lab: " + idLaboratorio);
		
		this.entityManager.getTransaction().begin();
		RegistroRepositorio registroRepositorio = new RegistroRepositorio();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		registroRepositorio.adicionar(professor.getId(), laboratorio, "sair", dtf.format(now));
		this.entityManager.getTransaction().commit();
	}

}