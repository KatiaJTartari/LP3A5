package br.edu.ifsp.lp3a5.aula03.produtorConsumidor2;

// A classe de driver que cria a �nica Fila, Produtor e Consumidor
public class Main {
	public static void main(String args[]) {
		// criando fila de buffer
		Fila f = new Fila();

		// iniciando a thread do consumidor
		new Consumidor(f);

		// iniciando a thread do produtor
		new Produtor(f);
	}
}