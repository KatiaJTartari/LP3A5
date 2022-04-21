package br.edu.ifsp.lp3a5.produtorConsumidor2;

// Classe Consumidor: o objeto encadeado que está consumindo entradas da fila
public class Consumidor implements Runnable {
	Fila f;

	Consumidor(Fila f) {
		this.f = f;
		new Thread(this, "Consumidor").start();
	}

	public void run() {
		for (int i = 0; i < 10; i++)
			// Consumidor retira itens
			f.get();
	}
}
