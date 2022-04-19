package br.edu.ifsp.lp3a5.aula1;

public class Aluno {
	
	private String matricula;
    private String nome;
    final private Disciplina disciplina;
           
    public static void main(String[] args) {
		
	    Aluno aluno1 = new Aluno("SP3013251", "Katia J Tartari"); 
	    
	    aluno1.disciplina.setNomeDisciplina("LP3A5 - Linguagem de Programa��o III");
	    aluno1.disciplina.setQtdPresenca(18);
	    aluno1.disciplina.setNotaExercicios(10f);
	    aluno1.disciplina.setNotaProva(8f);
	    aluno1.disciplina.setNotaTrabalho(9f);
	    	    
	    System.out.println("Aluno: " + aluno1.getNome() + " - Matr�cula: " + aluno1.getMatricula());
	    System.out.println("Disciplina: " + aluno1.disciplina.getNomeDisciplina());
	    System.out.println("Quantidade Total de Presen�as: " + aluno1.disciplina.getQtdPresenca());
	    System.out.println("Nota Exerc�cios: " + aluno1.disciplina.getNotaExercicios() + 
	    		           " - Nota Prova: " + aluno1.disciplina.getNotaProva() + 
	    		           " - Nota Trabalho: " + aluno1.disciplina.getNotaTrabalho());
	    System.out.println("M�dia Final: " + aluno1.disciplina.calculaMediaFinal());
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
