package view;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

import modelo.Registro;
import repositorio.RegistroRepositorio;
import util.ViewUtils;

public class RegistroView {
	
	public static void displayRegistroOptions() {
		while (true) {
			int option = 0;
			String optionStr = JOptionPane
					.showInputDialog("REGISTROS\n" + "1. Todos os registros\n" + "2. registro por pessoa\n"
							+ "3. registro por laboratorio\n" + "Clique cancelar para voltar\n" + "Escolha uma opcão:");

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
				exibirTodos();
				break;
			case 2:
				exibirPorPessoa();
				break;
			case 3:
				exibirPorLaboratorio();
				break;
			default:
				JOptionPane.showMessageDialog(null, "Valor inválido");
				break;
			}
		}
	}

	public static void exibirTodos() {
		RegistroRepositorio registroRepositorio = new RegistroRepositorio();
		List<Registro> todosRegistros = registroRepositorio.obterTodos();
		Gson gson = new GsonBuilder()
				  .excludeFieldsWithoutExposeAnnotation() //ignorar campos sem a anotação @Expose
				  .setPrettyPrinting() //formata o json para imprimir no console de forma mais legível 
				  .create();
		String jsonString = gson.toJson(todosRegistros);
		
		ViewUtils.textArea(jsonString, 20, 20);
		
	}

	public static void exibirPorPessoa() {
		RegistroRepositorio registroRepositorio = new RegistroRepositorio();
		Long id = Long.parseLong(JOptionPane.showInputDialog("Qual é o id da pessoa?"));
		ArrayList<Registro> registros = registroRepositorio.obterPorPessoa(id);
		Gson gson = new GsonBuilder()
				  .excludeFieldsWithoutExposeAnnotation() //ignorar campos sem a anotação @Expose
				  .setPrettyPrinting() //formata o json para imprimir no console de forma mais legível 
				  .create();
		String jsonString = gson.toJson(registros);
		
		ViewUtils.textArea(jsonString, 20, 20);
	}

	public static void exibirPorLaboratorio() {
		RegistroRepositorio registroRepositorio = new RegistroRepositorio();
		Long id = Long.parseLong(JOptionPane.showInputDialog("Qual é o id do laboratorio?"));
		ArrayList<Registro> registros = registroRepositorio.obterPorLaboratorio(id);
		
		Gson gson = new GsonBuilder()
				  .excludeFieldsWithoutExposeAnnotation() //ignorar campos sem a anotação @Expose
				  .setPrettyPrinting() //formata o json para imprimir no console de forma mais legível 
				  .create();
		String jsonString = gson.toJson(registros);
		
		ViewUtils.textArea(jsonString, 20, 20);
	}
	
	


}
