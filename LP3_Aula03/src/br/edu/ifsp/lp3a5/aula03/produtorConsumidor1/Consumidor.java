package br.edu.ifsp.lp3a5.aula03.produtorConsumidor1;

public class Consumidor extends Thread {
	private Buffer buffer;
	private int id;

	public Consumidor(Buffer b, int id) {
		buffer = b;
		this.id = id;
	}

	public void run() {
		int valor = 0;
		for (int i = 0; i < 10; i++) {
			valor = buffer.get();
			System.out.println("Consumidor " + this.id + " consome: " + valor);
		}
	}

}
