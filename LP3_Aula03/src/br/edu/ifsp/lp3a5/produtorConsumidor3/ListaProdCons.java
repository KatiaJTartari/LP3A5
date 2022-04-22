package br.edu.ifsp.lp3a5.produtorConsumidor3;

import java.util.LinkedList;

//Esta classe tem uma lista, produtor (adiciona itens � lista)
// e consumidor (remove itens).
public class ListaProdCons {

	// Cria uma lista compartilhada por produtor e consumidor
	// O tamanho da lista � 2.
	LinkedList<Integer> lista = new LinkedList<>();
	int tam = 2;

	// Fun��o chamada pela thread do produtor
	public void produzir() throws InterruptedException {
		int valor = 0;
		while (true) {
			synchronized (this) {
				// Thread do produtor espera enquanto a lista est� cheia
				while (lista.size() == tam)
					wait();

				System.out.println("Produtor produz --> " + valor);

				// Para inserir os trabalhos na lista
				lista.add(valor++);

				// Notifica a thread consumidor que agora ela pode come�ar a consumir
				notify();

				// Torna o funcionamento do programa mais f�cil de entender
				Thread.sleep(1000);
			}
		}
	}

	// Fun��o chamada pela thread consumidor
	public void consumir() throws InterruptedException {
		while (true) {
			synchronized (this) {
				// Thread consumidor espera enquanto a lista est� vazia
				while (lista.size() == 0)
					wait();

				// Para recuperar o primeiro trabalho na lista
				int valor = lista.removeFirst();

				System.out.println("Consumidor consome --> " + valor);

				// Ativa a thread do produtor
				notify();

				// E dormir
				Thread.sleep(1000);
			}
		}
	}
}