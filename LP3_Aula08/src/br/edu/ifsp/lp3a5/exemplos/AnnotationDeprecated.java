package br.edu.ifsp.lp3a5.exemplos;

public class AnnotationDeprecated {

	public static void main(String[] args) {
	}

	public class Funcionario {
		protected double salario;

		@Deprecated
		public double getSalarioTotal(double bonus) {
			return this.salario + bonus;
		}

		public double getTotalSalario(double bonus) {
			return this.salario + bonus;
		}
	}

}
