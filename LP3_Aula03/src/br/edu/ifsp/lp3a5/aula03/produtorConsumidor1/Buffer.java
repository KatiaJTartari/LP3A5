package br.edu.ifsp.lp3a5.aula03.produtorConsumidor1;

public class Buffer {
	private int conteudo;
	private boolean disponivel = false;

	public synchronized int get() {
		while (disponivel == false) {
			try {
				wait(); // Método wait "espera"
			} catch (InterruptedException e) {
			}
		}
		disponivel = false;
		notifyAll();
		return conteudo;
	}

	public synchronized void put(int value) {
		while (disponivel == true) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		conteudo = value;
		disponivel = true;
		notifyAll();
	}
}
