package br.edu.ifsp.lp3a5.aula03.produtorConsumidor1;

public class Buffer {
	private int conteudo;
	private boolean disponivel = false;

	/*
	 * A sincronização ocorre a baixo nível, nos métodos put() e get().
	 * 
	 * O método wait() larga o trinco mantido pelo consumidor no Buffer (permitindo
	 * assim que o produtor re-adquira o trinco) e fica à espera de uma notificação
	 * por parte do produtor.
	 * 
	 * O método notifyAll() acorda todas as threads em espera no objeto em causa (o
	 * Buffer); com isso as threads acordadas competem pelo trinco, uma dessas
	 * threads obtém o trinco, as outras voltam a esperar
	 */

	public synchronized int get() {
		// O consumidor obtém o trinco do Buffer
		while (disponivel == false) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		// O consumidor liberta o trinco do Buffer
		disponivel = false;
		notifyAll();
		return conteudo;
	}

	public synchronized void put(int valor) {
		// O produtor obtém o trinco do Buffer
		while (disponivel == true) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}
		// O produtor liberta o trinco do Buffer
		conteudo = valor;
		disponivel = true;
		notifyAll();
	}
}
