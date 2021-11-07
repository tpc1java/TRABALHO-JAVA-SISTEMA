package view;

import javax.swing.JOptionPane;

import modelo.Aluno;
import modelo.Laboratorio;
import modelo.Professor;
import modelo.Turno;
import repositorio.AlunoRepositorio;
import repositorio.LaboratorioRepositorio;
import repositorio.ProfessorRepositorio;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
public class CadastroView {
	
	public static void displayCadastroOptions() {
		while (true) {
			int option = 0;
			String optionStr = JOptionPane.showInputDialog("CADASTRO\n" + "1. aluno\n" + "2. professor\n" + "3. laboratorio\n"
					+ "Clique cancelar para voltar\n" + "Escolha uma opcão:");

			if (optionStr == null) {
				break;
			}

			try {
				option = Integer.parseInt(optionStr);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Apenas valores numéricos são válidos", "Erro",
						JOptionPane.WARNING_MESSAGE);
				continue;
			}

			switch (option) {
			case 1:
				displayCadastroAluno();
				break;
			case 2:
				displayCadastroProfessor();
				break;
			case 3:
				displayCadastroLaboratorio();
				break;
			default:
				JOptionPane.showMessageDialog(null, "Valor inválido");
				break;
			}
		}
	}

	public static void displayCadastroAluno() {
		AlunoRepositorio alunoRepositorio = new AlunoRepositorio();
		String nome;
		String email;
		String cpf;
		String turno;

		email = JOptionPane.showInputDialog("Qual é o email?");
		cpf = JOptionPane.showInputDialog("Qual é o cpf?");
		nome = JOptionPane.showInputDialog("Qual é o nome?");
		turno = JOptionPane.showInputDialog("Qual é o turno (MATUTINO, VESPERTINO ou NORTUNO)?");
		
		if(! turno.equals("MATUTINO") && !turno.equals("VESPERTINO") && !turno.equals("NORTUNO")) {
			JOptionPane.showMessageDialog(null, "Turno inválido.");
			return;
		} else if (email == null|| nome == null|| cpf == null|| cpf == turno) {
			JOptionPane.showMessageDialog(null, "Valor inválido");
			return;
		}

		
		Aluno novo = alunoRepositorio.adicionar(nome, email, cpf, Turno.valueOf(turno));
		Gson gson = new Gson();
		String alunoJsonString = gson.toJson(novo);
		JOptionPane.showMessageDialog(null, "Aluno adicionado com sucesso\n" + alunoJsonString);
	}

	public static void displayCadastroProfessor() {

		ProfessorRepositorio professorRepositorio = new ProfessorRepositorio();

		String nome;
		String email;
		String cpf;

		email = JOptionPane.showInputDialog("Qual é o email?");
		cpf = JOptionPane.showInputDialog("Qual é o cpf?");
		nome = JOptionPane.showInputDialog("Qual é o nome?");
		
		if (email == null|| nome == null|| cpf == null) {
			JOptionPane.showMessageDialog(null, "Valor inválido");
			return;
		}

		Professor novo = professorRepositorio.adicionar(nome, email, cpf);
		Gson gson = new Gson();
		String professorJsonString = gson.toJson(novo);
		JOptionPane.showMessageDialog(null, "Professor adicionado com sucesso\n" + professorJsonString);
		
	}
	
	public static void displayCadastroLaboratorio() {

		LaboratorioRepositorio laboratorioRepositorio = new LaboratorioRepositorio();

	
		
		String codigo = JOptionPane.showInputDialog("Qual é o código da sala de laboratório?");
		String totalAssentos = JOptionPane.showInputDialog("Qual é o total de assentos?");
		
		
		if (codigo == null || totalAssentos == null) {
			JOptionPane.showMessageDialog(null, "Valor inválido");
			return;
		}
		
		int totalAssentosInt = Integer.parseInt(totalAssentos);

		Laboratorio novo = laboratorioRepositorio.adicionar(codigo, totalAssentosInt);
		Gson gson = new Gson();
		String professorJsonString = gson.toJson(novo);
		JOptionPane.showMessageDialog(null, "Laboratório adicionado com sucesso\n" + professorJsonString);
		
	}


}
