package br.edu.ifsp.lp3a5.aula03.produtorConsumidor1;

public class Produtor extends Thread {
	private Buffer buffer;
	private int id;

	public Produtor(Buffer b, int id) {
		buffer = b;
		this.id = id;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			buffer.put(i);
			System.out.println("Produtor " + this.id + " coloca: " + i);
			try {
				sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
			}
		}
	}
}
