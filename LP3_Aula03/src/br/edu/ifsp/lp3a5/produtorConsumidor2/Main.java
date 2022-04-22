package br.edu.ifsp.lp3a5.produtorConsumidor2;

// A classe de driver que cria a única Fila, Produtor e Consumidor
public class Main {
	public static void main(String args[]) {
		// Criando fila de buffer
		Fila f = new Fila();

		// Iniciando a thread do consumidor
		new Consumidor(f);

		// Iniciando a thread do produtor
		new Produtor(f);
	}
}
