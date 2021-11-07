package view;

import javax.swing.JOptionPane;

public class MenuView {

	public static void displayMenu() {
		while (true) {
			int option = 0;
			String optionStr = JOptionPane.showInputDialog("MENU PRINCIPAL\n" + "1. cadastro\n"
			+ "2. editar\n" + "3. registro\n" + "4. Acesso laboratório\n" + "5. Sair do laboratório\n"+ "6. Sair do sistema\n"+"Escolha uma opcão:");
			
			if(optionStr == null) {
				System.exit(0);
			}
			
			try {
				option = Integer.parseInt(optionStr);
			} catch(NumberFormatException e) {
				 JOptionPane.showMessageDialog(null, "Apenas valores numéricos são válidos", "Erro", JOptionPane.WARNING_MESSAGE);
				 continue;
			}
			
			switch (option) {
			case 1:
				CadastroView.displayCadastroOptions();
				break;
			case 2:
				EditarView.displayEditarOptions();
				break;
			case 3:
				RegistroView.displayRegistroOptions();
				break;
			case 4:
				AcessoLaboratorioView.displayAcessoLaboratorioOptions();
				break;
			case 5:
				SairLaboratorioView.displaySairLaboratorioOptions();
				break;
			case 6:
				System.exit(0);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Valor inválido");
				break;
			}
		}
	}

}
