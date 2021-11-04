package repositorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import modelo.Laboratorio;
import modelo.Registro;
import modelo.Turno;

import java.util.ArrayList;
import java.util.Date;


public class RegistroRepositorio {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-jpa");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	public RegistroRepositorio() {

	}

	public Registro obterPorId(Long id) {
		Registro registro = entityManager.find(Registro.class, id);
		return registro != null ? registro : null;
	}

	public ArrayList<Registro> obterTodos() {
	        return (ArrayList<Registro>) entityManager.createQuery("from Registro").getResultList();
	 }

	public Registro adicionar (Long idPessoa, Laboratorio laboratorio, String acao,String horaDeEntrada) {
		Registro novoRegistro = new Registro(idPessoa,  laboratorio, acao ,horaDeEntrada);
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(novoRegistro);
		this.entityManager.getTransaction().commit();
		System.out.println("Registro adicionado com sucesso");
		return novoRegistro;
	}
	
	
		
}