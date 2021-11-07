package view;

import javax.swing.JOptionPane;

import com.google.gson.Gson;

import modelo.Aluno;
import modelo.Professor;
import modelo.Turno;
import repositorio.AlunoRepositorio;
import repositorio.ProfessorRepositorio;

public class EditarView {

	public static void displayEditarOptions() {
		while (true) {
			int option = 0;
			String optionStr = JOptionPane.showInputDialog("EDITAR\n" + "1. aluno\n"
			+ "2. professor\n" + "Clique cancelar para voltar\n"+"Escolha uma opcão:");
			
			if(optionStr == null) {
				break;
			}
			
			try {
				option = Integer.parseInt(optionStr);
			} catch(NumberFormatException e) {
				 JOptionPane.showMessageDialog(null, "Apenas valores numéricos são válidos", "Erro", JOptionPane.WARNING_MESSAGE);
				 continue;
			}
			
			switch (option) {
			case 1:
				displayEditarAluno();
				break;
			case 2:
				displayEditarProfessor();
				break;
			default:
				JOptionPane.showMessageDialog(null, "Valor inválido");
				break;
			}
		}
	}
	
	public static void displayEditarAluno() {
		AlunoRepositorio alunoRepositorio = new AlunoRepositorio();
		String nome;
		String email;
		String cpf;
		String turno;
		
		Long id = Long.parseLong(JOptionPane.showInputDialog("Qual é o id?"));
		if(alunoRepositorio.obterPorId(id) == null) {
			JOptionPane.showMessageDialog(null, "Não encontramos um id corresponte na base de dados.");
			return;
		}
		email = JOptionPane.showInputDialog("Qual é o novo email?");
		cpf = JOptionPane.showInputDialog("Qual é o novo cpf?");
		nome = JOptionPane.showInputDialog("Qual é o novo nome?");
		turno = JOptionPane.showInputDialog("Qual é o novo turno?");
		if(! turno.equals("MATUTINO") && !turno.equals("VESPERTINO") && !turno.equals("NORTUNO")) {
			JOptionPane.showMessageDialog(null, "Turno inválido.");
			return;
		} else if (email == null|| nome == null|| cpf == null|| cpf == turno || id == null) {
			JOptionPane.showMessageDialog(null, "Valor inválido");
			return;
		}

		
		Aluno atualizado = alunoRepositorio.atualizar(id,nome, email, cpf, Turno.valueOf(turno));
		Gson gson = new Gson();
		String professorJsonString = gson.toJson(atualizado);
		JOptionPane.showMessageDialog(null, "Aluno atualizado com sucesso\n" + professorJsonString);
	}

	public static void displayEditarProfessor() {

		ProfessorRepositorio professorRepositorio = new ProfessorRepositorio();

		String nome;
		String email;
		String cpf;
		
		Long id = Long.parseLong(JOptionPane.showInputDialog("Qual é o id?"));
		if(professorRepositorio.obterPorId(id) == null) {
			JOptionPane.showMessageDialog(null, "Não encontramos um id corresponte na base de dados.");
			return;
		}
		email = JOptionPane.showInputDialog("Qual é o novo email?");
		cpf = JOptionPane.showInputDialog("Qual é o novo cpf?");
		nome = JOptionPane.showInputDialog("Qual é o novo nome?");

		if (email == null|| nome == null|| cpf == null || id == null) {
			JOptionPane.showMessageDialog(null, "Valor inválido");
			return;
		}

		Professor atualizado = professorRepositorio.atualizar(id, nome, email, cpf);
		Gson gson = new Gson();
		String professorJsonString = gson.toJson(atualizado);
		JOptionPane.showMessageDialog(null, "Professor atualizado com sucesso\n" + professorJsonString);
	}

}
