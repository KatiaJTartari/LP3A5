package br.edu.ifsp.lp3a5.aula03.produtorConsumidor2;

// Classe Produtor: o objeto encadeado que está produzindo entradas na fila
public class Produtor implements Runnable {
	Fila f;

	Produtor(Fila f) {
		this.f = f;
		new Thread(this, "Produtor").start();
	}

	public void run() {
		for (int i = 0; i < 10; i++)
			// produtor coloca itens
			f.put(i);
	}
}