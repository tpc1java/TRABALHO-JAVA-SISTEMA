import repositorio.AlunoRepositorio;
import repositorio.LaboratorioRepositorio;
import repositorio.ProfessorRepositorio;
import modelo.Aluno;
import modelo.Laboratorio;
import modelo.Professor;
import modelo.Turno;

public class Main {

	public static void main(String[] args) {
		
		AlunoRepositorio ar = new AlunoRepositorio();
		ProfessorRepositorio pr = new ProfessorRepositorio();
		LaboratorioRepositorio lr = new LaboratorioRepositorio();
		//testar adds;
		
		Aluno a1 = ar.adicionar("Leo", "leozinho@hotmail.com", "96339291902", Turno.valueOf("VESPERTINO"));
		Aluno a2 = ar.adicionar("Gabriel", "gabe@hotmail.com", "12359291902", Turno.valueOf("MATUTINO"));
		
		
		Professor p1 = pr.adicionar("Lucas", "lucas@hotmail.com", "07887667654");
		
		Laboratorio l = lr.adicionar("12131", 10);
		
		lr.autenticarAluno(l.getId(), a1);
		lr.autenticarAluno(l.getId(), a2);
	}

}
