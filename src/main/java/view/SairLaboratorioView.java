package view;

import javax.swing.JOptionPane;

import modelo.Aluno;
import modelo.Laboratorio;
import modelo.Professor;
import modelo.Turno;
import repositorio.AlunoRepositorio;
import repositorio.LaboratorioRepositorio;
import repositorio.ProfessorRepositorio;
import repositorio.RegistroRepositorio;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
public class SairLaboratorioView {
	
	public static void displaySairLaboratorioOptions() {
		while (true) {
			int option = 0;
			String optionStr = JOptionPane.showInputDialog("Sair do laboratorio\n" + "1. aluno\n" + "2. professor\n"
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
				displayDesautenticarAluno();
				break;
			case 2:
				displayDesautenticarProfessor();
				break;
			default:
				JOptionPane.showMessageDialog(null, "Valor inválido");
				break;
			}
		}
	}

	public static void displayDesautenticarAluno() {
		
			RegistroRepositorio registroRepositorio = new RegistroRepositorio();
			LaboratorioRepositorio laboratorioRepositorio = new LaboratorioRepositorio(); 
			AlunoRepositorio alunoRepositorio = new AlunoRepositorio();
			
			Long idAluno = (long) 0;
			Long idLaboratorioLong= (long) 0;
			
			String idPessoa = JOptionPane.showInputDialog("Qual é o seu id?");

			if (idPessoa == null) {
				return;
			}

			try {
				idAluno = Long.parseLong(idPessoa);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Apenas valores numéricos são válidos", "Erro",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			Aluno aluno = alunoRepositorio.obterPorId(idAluno);
			if(aluno == null ) {
				JOptionPane.showMessageDialog(null, "Não encontramos esse id de aluno na base de dados");
				return;
			}
			
			String idLaboratorio = JOptionPane.showInputDialog("Qual é o seu id do laboratorio?");
			
			
			if (idLaboratorio == null) {
				return;
			}
			
			try {
				idLaboratorioLong = Long.parseLong(idLaboratorio);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Apenas valores numéricos são válidos", "Erro",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			Laboratorio lab = laboratorioRepositorio.obterPorId(idLaboratorioLong);
			if(lab == null) {
				JOptionPane.showMessageDialog(null, "Não encontramos esse id de laboratório na base de dados");
				return;
			}
			laboratorioRepositorio.desautenticarAluno(idLaboratorioLong, aluno);
			JOptionPane.showMessageDialog(null, "Aluno " + idAluno + " desautenticado com sucesso.");
			
	}

	public static void displayDesautenticarProfessor() {
		RegistroRepositorio registroRepositorio = new RegistroRepositorio();
		LaboratorioRepositorio laboratorioRepositorio = new LaboratorioRepositorio(); 
		ProfessorRepositorio professorRepositorio = new ProfessorRepositorio();
		
		Long idProfessor = (long) 0;
		Long idLaboratorioLong= (long) 0;
		
		String idPessoa = JOptionPane.showInputDialog("Qual é o seu id?");

		if (idPessoa == null) {
			return;
		}

		try {
			idProfessor = Long.parseLong(idPessoa);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Apenas valores numéricos são válidos", "Erro",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		Professor professor = professorRepositorio.obterPorId(idProfessor);
		if(professor == null ) {
			JOptionPane.showMessageDialog(null, "Não encontramos esse id de professor na base de dados");
		}
		
		String idLaboratorio = JOptionPane.showInputDialog("Qual é o seu id do laboratorio?");
		
		
		if (idLaboratorio == null) {
			return;
		}
		
		try {
			idLaboratorioLong = Long.parseLong(idLaboratorio);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Apenas valores numéricos são válidos", "Erro",
					JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		Laboratorio lab = laboratorioRepositorio.obterPorId(idLaboratorioLong);
		if(lab == null) {
			JOptionPane.showMessageDialog(null, "Não encontramos esse id de laboratório na base de dados");
		}
		laboratorioRepositorio.desautenticarProfessor(idLaboratorioLong, professor);
		JOptionPane.showMessageDialog(null, "Professor " + idProfessor + " desautenticado com sucesso.");
		
	}

}
