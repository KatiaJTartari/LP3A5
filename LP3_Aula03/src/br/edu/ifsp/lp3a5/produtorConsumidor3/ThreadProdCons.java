package br.edu.ifsp.lp3a5.produtorConsumidor3;

public class ThreadProdCons {
	public static void main(String[] args) throws InterruptedException {

		// Objeto de uma classe que possui métodos de produção() e consumo()
		final ListaProdCons pc = new ListaProdCons();

		// Criar thread do produtor
		Thread tProd = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.produzir();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Criar thread do consumidor
		Thread tCons = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					pc.consumir();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		// Iniciar ambos threads
		tProd.start();
		tCons.start();

		// tProd termina antes de tCons
		tProd.join();
		tCons.join();
	}

}