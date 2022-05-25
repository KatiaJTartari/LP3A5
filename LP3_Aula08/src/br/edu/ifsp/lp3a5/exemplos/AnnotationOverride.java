package br.edu.ifsp.lp3a5.exemplos;

public class AnnotationOverride {

	public static void main(String[] args) {
	}

	class Funcionario {
		protected double salario;

		public double getSalarioTotal(double bonus) {
			return this.salario + bonus;
		}
	}

	class Auxiliar extends Funcionario {
		protected double extra;

		@Override
		// A inclusão dessa anotação irá alertar para uma falha caso o método da
		// subclasse não sobrescreva o método da superclasse se fosse:
		// public double getSalarioTotal(float bonus) {
		public double getSalarioTotal(double bonus) {
			return this.salario + this.extra + bonus;
		}
	}

}
