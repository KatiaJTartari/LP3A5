package br.edu.ifsp.lp3a5.aula03.produtorConsumidor2;

//Implementa��o Java de um produtor e consumidor
//que usam sem�foros para controlar a sincroniza��o.

import java.util.concurrent.Semaphore;

// A fila que voc� est� tentando sincronizar
public class Fila {

	int item;

	// semCon inicializado com 0 permiss�es
	// para garantir que put() execute primeiro
	static Semaphore semCon = new Semaphore(0);

	static Semaphore semProd = new Semaphore(1);

	// para obter um item do buffer
	void get() {
		try {
			// Antes que o consumidor possa consumir um item,
			// deve adquirir uma licen�a da semCon
			semCon.acquire();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException caught");
		}

		// consumidor consumindo um item
		System.out.println("Consumidor consome : " + item);

		// Ap�s o consumidor consumir o item,
		// libera semProd para notificar o produtor
		semProd.release();
	}

	// para colocar um item no buffer
	void put(int item) {
		try {
			// Antes que o produtor possa produzir um item,
			// deve adquirir uma licen�a da semProd
			semProd.acquire();
		} catch (InterruptedException e) {
			System.out.println("InterruptedException caught");
		}

		// produtor produzindo um item
		this.item = item;

		System.out.println("Produtor produz : " + item);

		// Ap�s o produtor produzir o item,
		// ele libera o semCon para notificar o consumidor
		semCon.release();
	}
}
