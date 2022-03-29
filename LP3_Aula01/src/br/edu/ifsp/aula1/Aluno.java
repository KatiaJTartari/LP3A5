package br.edu.ifsp.aula1;

public class Aluno {
	
	private String matricula;
    private String nome;
    final private Disciplina disciplina;
           
    public static void main(String[] args) {
		// TODO Auto-generated method stub
	    Aluno aluno1 = new Aluno("SP3013251", "Katia J Tartari"); 
	    
	    aluno1.disciplina.setNomeDisciplina("LP3A5 - Linguagem de Programação III");
	    aluno1.disciplina.setQtdPresenca(18);
	    aluno1.disciplina.setNotaExercicios(10f);
	    aluno1.disciplina.setNotaProva(7f);
	    aluno1.disciplina.setNotaTrabalho(8f);
	    	    
	    System.out.println("Aluno: " + aluno1.getNome() + " - Matrícula: " + aluno1.getMatricula());
	    System.out.println("Disciplina: " + aluno1.disciplina.getNomeDisciplina());
	    System.out.println("Quantidade Total de Presenças: " + aluno1.disciplina.getQtdPresenca());
	    System.out.println("Nota Exercícios: " + aluno1.disciplina.getNotaExercicios() + 
	    		           " - Nota Prova: " + aluno1.disciplina.getNotaProva() + 
	    		           " - Nota Trabalho: " + aluno1.disciplina.getNotaTrabalho());
	    System.out.println("Média Final: " + aluno1.disciplina.calculaMediaFinal());
	    aluno1.disciplina.passouDeAno();
	}
    
    public Aluno(String matricula, String nome) {
 	   this.matricula = matricula;
 	   this.nome = nome;
 	   this.disciplina = new Disciplina();
    }
    	   
    public String getMatricula() {
	   return matricula;
    }
  
    public String getNome() {
	   return nome;
    }
 
}
