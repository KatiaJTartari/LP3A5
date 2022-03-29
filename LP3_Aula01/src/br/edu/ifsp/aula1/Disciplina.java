package br.edu.ifsp.aula1;

public class Disciplina {

	final public static int QTDAULAS = 20;
	private String nomeDisciplina;
	private int qtdPresenca;
	private float notaProva;
	private float notaTrabalho;
	private float notaExercicios;

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	
	public int getQtdPresenca() {
		return qtdPresenca;
	}

	public void setQtdPresenca(int qtdPresenca) {
		this.qtdPresenca = qtdPresenca;
	}
	
	public float getNotaProva() {
		return notaProva;
	}

	public void setNotaProva(float notaProva) {
		this.notaProva = notaProva;
	}

	public float getNotaTrabalho() {
		return notaTrabalho;
	}

	public void setNotaTrabalho(float notaTrabalho) {
		this.notaTrabalho = notaTrabalho;
	}

	public float getNotaExercicios() {
		return notaExercicios;
	}

	public void setNotaExercicios(float notaExercicios) {
		this.notaExercicios = notaExercicios;
	}

	
	public float calculaMediaFinal() {
		float mediaFinal = this.getNotaProva() * 0.4f + this.getNotaTrabalho() * 0.4f + this.getNotaExercicios() * 0.2f;
		// Ou:
		//float mediaFinal = notaProva * 0.4f + notaTrabalho * 0.4f + notaExercicios * 0.2f;
		return mediaFinal;
	}

	public boolean temPresencaSuficiente() {
		double presencaTotal = this.getQtdPresenca() * 100 / QTDAULAS;
		if (presencaTotal >= 75) {
			return true;
		} else {
			return false;
		}
	}
	
	public void passouDeAno() {
		if (this.temPresencaSuficiente()) {
			if (this.calculaMediaFinal() >= 6) {
			System.out.println("Aprovado!");
			}else if (this.calculaMediaFinal() >= 4) {
				System.out.println("IFA!");
			}else  {
				System.out.println("Reprovado!");
			}
		} else {
			System.out.println("Reprovado por falta!");
		}
	
	}

}
